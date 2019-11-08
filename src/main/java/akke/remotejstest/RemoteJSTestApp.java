package akke.remotejstest;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.impl.engine.client.PoolConductor;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.routing.RoundRobinPool;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import static akka.http.javadsl.server.Directives.*;

public class RemoteJSTestApp extends AllDirectives {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
//        ActorRef router = system.actorOf(
//                new RoundRobinPool(1)
//                .props(Props.create(StoreActor.class)),
//                "Router for lab"
//        );
        ActorRef RouteActor = system.actorOf(Props.create(RouterActor.class),"mainRouter");
        final Http http = Http.get(system);
        RemoteJSTestApp instance = new RemoteJSTestApp();
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest,HttpResponse, NotUsed> routeFlow = instance.createRoute().flow(system,)
    }


    public Route createRoute() {
        // This handler generates responses to `/hello?name=XXX` requests
        Route helloRoute =
                parameterOptional("name", optName -> {
                    String name = optName.orElse("Mister X");
                    return complete("Hello " + name + "!");
                });

        return
                // here the complete behavior for this server is defined

                // only handle GET requests
                get(() -> concat(
                        // matches the empty path
                        pathSingleSlash(() ->
                                // return a constant string with a certain content type
                                complete(HttpEntities.create(ContentTypes.TEXT_HTML_UTF8, "<html><body>Hello world!</body></html>"))
                        ),
                        path("ping", () ->
                                // return a simple `text/plain` response
                                complete("PONG!")
                        ),
                        path("hello", () ->
                                // uses the route defined above
                                helloRoute
                        )
                ));
    }
}
