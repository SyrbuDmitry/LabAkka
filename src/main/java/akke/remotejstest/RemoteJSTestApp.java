package akke.remotejstest;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.impl.engine.client.PoolConductor;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.routing.RoundRobinPool;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;

public class RemoteJSTestApp extends AllDirectives {
    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("lab4");
//        ActorRef router = system.actorOf(
//                new RoundRobinPool(1)
//                .props(Props.create(StoreActor.class)),
//                "Router for lab"
//        );
        ActorRef RouteActor = system.actorOf(Props.create(RouterActor.class));
        final Http http = Http.get(system);

        RemoteJSTestApp instance = new RemoteJSTestApp();
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.createRoute(RouteActor).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8085),
                materializer
        );
        System.out.println("Server online at http://localhost:8085/\nPress RETURN to stop...");

        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }


    private Route createRoute(ActorRef RouteActor) {
        return
                route(
                        pathSingleSlash(() ->
                                get(() ->
                                        parameter("packageID", id -> {
                                                    RouteActor.tell(new GetResaultMessage(Integer.parseInt(id)), ActorRef.noSender());
                                                    return complete("Request sent!");
                                                }
                                        )
                                )
                        ),

                        pathSingleSlash(() ->
                                post(() -> entity(Jackson.unmarshaller(PostRequestBody.class), msg -> {
                                    for (Test t : msg.tests) {
                                        RouteActor.tell(new TestScript(Integer.parseInt(msg.packageId), msg.functionName, msg.JsScript, t.params), ActorRef.noSender());
                                    }
                                    return complete("Tests started!");
                                }))
                        )
                );
    }
}
