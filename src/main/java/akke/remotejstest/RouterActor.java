package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.pattern.Patterns;
import akka.routing.RoundRobinPool;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import static java.util.concurrent.TimeUnit.SECONDS;

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
                .match(GetResultMessage.class, r->{
                   // Future<Object> futureResults = Patterns.ask(StoreActor,r,5000);
                    //ResultsMessage storedResults = (ResultsMessage)Await.result(futureResults, Duration.create(2, SECONDS));
                    StoreActor.tell(r,sender());
                    //sender().tell(storedResults,self());
                })
                .build();
    }
}
