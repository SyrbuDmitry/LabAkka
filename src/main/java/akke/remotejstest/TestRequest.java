package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import org.apache.commons.collections4.map.MultiValueMap;
import

public class TestRequest extends AbstractActor {
    private MultiValueMap<String,String> store = new MultiValueMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreTestResaultMessage.class, m -> {
                store.put(m.getID(), m.getResault());
                System.out.println("receive message! "+m.toString());
                })
                .match(GetResaultMessage.class, req -> sender().tell(
                        new ResualtsMessage(req.getID(), store.get(req.getID())), self())
                ).build();
    }
}
