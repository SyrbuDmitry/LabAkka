package akke.remotejstest;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.routing.RoundRobinPool;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class RemoteJSTestApp extends AllDirectives{
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
//        ActorRef router = system.actorOf(
//                new RoundRobinPool(1)
//                .props(Props.create(StoreActor.class)),
//                "Router for lab"
//        );
        ActorRef RouteActor = system.actorOf(Props.create(RouterActor.class),"mainRouter");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        RemoteJSTestApp instance = new RemoteJSTestApp(system);
        final Flow<HttpRequest,HttpResponse, NotUsed> routeFlow =
    }
}
