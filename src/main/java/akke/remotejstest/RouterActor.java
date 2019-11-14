package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.pattern.Patterns;
import akka.pattern.PatternsCS;
import akka.routing.RoundRobinPool;
import scala.concurrent.Future;


public class RouterActor extends AbstractActor {
    private ActorRef StoreActor = getContext().actorOf(Props.create(StoreActor.class),"storeActor");
    private ActorRef TestRouter = getContext().actorOf(
            new RoundRobinPool(5)
                    .props(Props.create(TestActor.class))
    );
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMessage.class, t->StoreActor.tell(t,self()))
                .match(TestScript.class, s->TestRouter.tell(s,self()))
                .match(GetResaultMessage.class, r->{
                    System.out.println(sender().toString());
                    Future<Object> result = Patterns.ask(StoreActor,r,5000);
                    sender().tell();

                })
                .match(ResultsMessage.class, r ->{
                    System.out.println("RECEIVED REUSLTS IN ROUTERACTOR"+sender().toString());
                    System.out.println("RESULTS: "+r.getResaults());

                })
                .build();
    }
}
