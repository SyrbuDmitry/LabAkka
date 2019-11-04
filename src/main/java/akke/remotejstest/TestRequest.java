package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import org.apache.commons.collections4.map.MultiValueMap;
import
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRequest extends AbstractActor {
    private MultiValueMap<String,String> store = new MultiValueMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreTestResault.class, m -> {
                store.put(m.getID(), m.getValue());
                System.out.println("receive message! "+m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreTestResault(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }
}
