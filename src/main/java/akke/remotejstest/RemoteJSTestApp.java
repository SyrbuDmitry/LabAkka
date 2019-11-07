package akke.remotejstest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RemoteJSTestApp {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef router = system.actorOf(
                new RoundRobinPool(1)
                .props(Props.create(StoreActor.class)),
                "Router for lab"
        );
        //ActorRef storeActor = system.actorOf(Props.create(StoreActor.class));
    }
}
