package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRequest extends AbstractActor {
    private Map<String,List<String>> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreTestResaultMessage.class, m -> {
                store.put(m.getID(), m.getResault());
                System.out.println("receive message! "+m.toString());
                })
                .match(GetResaultMessage.class, req -> sender().tell(
                        new ResualtsMessage(req.getID(), (List<String>)store.get(req.getID())), self())
                ).build();
    }
}
