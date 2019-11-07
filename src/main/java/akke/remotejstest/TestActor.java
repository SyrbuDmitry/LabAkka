package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class TestActor extends AbstractActor {
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestScript.class, m -> {
                    store.put(m.getID(), m.getResult());
                    System.out.println("receive message! "+m.toString());
                })
                .build();
    }
    }
}
