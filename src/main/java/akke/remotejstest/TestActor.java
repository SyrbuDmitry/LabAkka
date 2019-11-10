package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Array;

public class TestActor extends AbstractActor {

    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestScript.class, m -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(m.functionBody);
                    Invocable invocable = (Invocable) engine;
                    String params = String.valueOf(m.params[0])+","+String.valueOf(m.params[1]);
                    System.out.println(m.functionName+" "+m.functionBody+" "+params);
                    Integer[] pars = new Integer[m.params.length];
                    
                    sender().tell(
                            new TestResultMessage(m.packageID,invocable.invokeFunction(m.functionName, new Integer[]{1,2}).toString()),self()
                    );
                })
                .build();
    }
}
