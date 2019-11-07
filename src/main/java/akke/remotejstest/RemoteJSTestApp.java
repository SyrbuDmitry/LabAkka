package akke.remotejstest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinRoutingLogic;

public class RemoteJSTestApp {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef router = system.actorOf(
                new Props(TestRequest.class).withRouter(new RoundRobinRoutingLogic(5));
        )
        //ActorRef storeActor = system.actorOf(Props.create(TestRequest.class));
    }
}
