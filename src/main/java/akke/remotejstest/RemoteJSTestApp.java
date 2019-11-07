package akke.remotejstest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class RemoteJSTestApp {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("lab4");
        ActorRef storeActor = system.actorOf(Props.create(TestRequest.class));
    }
}
