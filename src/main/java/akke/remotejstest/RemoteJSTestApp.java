package akke.remotejstest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.routing.RoundRobinPool;
import akka.stream.ActorMaterializer;

public class RemoteJSTestApp {
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
        MainHttp instance = new MainHttp(system);
    }
}
