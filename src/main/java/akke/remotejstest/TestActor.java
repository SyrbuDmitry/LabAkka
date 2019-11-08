package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestActor extends AbstractActor {
    ActorRef storeActor = getContext().actorSelection("lab4/mainRouter/storeActor");
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestScript.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(m.functionBody);
                    Invocable invocable = (Invocable) engine;
                    sender().tell(
                            new TestResultMessage(m.packageID,invocable.invokeFunction(m.functionName, m.params).toString()),self()
                    );
                })
                .build();
    }
}
