package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().build();
    }
}
