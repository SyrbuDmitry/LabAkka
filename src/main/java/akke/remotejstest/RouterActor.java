package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;


public class RouterActor extends AbstractActor {
    private ActorRef StoreActor = getContext().actorOf(Props.create(StoreActor.class),"storeActor");
    private ActorRef TestRouter = getContext().actorOf(
            new RoundRobinPool(5)
                    .props(Props.create(TestActor.class))
    );
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMessage.class, t->StoreActor.tell(t,sender()))
                .match(TestScript.class, s->TestRouter.tell(s,sender()))
                .match(GetResaultMessage.class, r->{
                    System.out.println("GET RESULTS REQUEST IN ROUTERACTOR");
                    StoreActor.tell(r,self());

                })
                .match(ResultsMessage.class, r ->{
                    System.out.println("RECEIVED REUSLTS IN ROUTERACTOR");
                    System.out.println("RESULTS: "+r.getResaults());
                })
                .build();
    }
}
