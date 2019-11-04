package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Collection;
import java.util.List;

public class TestRequest extends AbstractActor {
    private MultiMap<String,String> store = new MultiValueMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreTestResaultMessage.class, m -> {
                store.put(m.getID(), m.getResault());
                System.out.println("receive message! "+m.toString());
                })
                .match(GetResaultMessage.class, req -> {
                    List<String> r = (List<String>)store.get(req.getID());
                    sender().tell(
                            new ResualtsMessage(req.getID(),r, self());
                        }
                ).build();
    }
}
