package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TestActor extends AbstractActor {

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
