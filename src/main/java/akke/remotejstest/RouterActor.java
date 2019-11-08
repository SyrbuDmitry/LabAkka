package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;


public class RouterActor extends AbstractActor {
    ActorRef StoreActor = getContext().actorOf(Props.create(StoreActor.class),"storeActor");
    ActorRef TestRouter = getContext().actorOf(
            new RoundRobinPool(5)
                    .props(Props.create(TestActor.class)),
            "Router for lab"
    );
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMessage.class, t->StoreActor.tell(t))



                .build();
    }
}
