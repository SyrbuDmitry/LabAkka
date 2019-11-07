package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestActor extends AbstractActor {
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestScript.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(jscript);
                    Invocable invocable = (Invocable) engine;
                    return invocable.invokeFunction(functionName, params).toString();

                })
                .build();
    }
    }
}
