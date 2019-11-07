package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String,String> store = new HashedMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(StoreTestResultMessage.class, m -> {
                store.put(m.getID(), m.getResult());
                System.out.println("receive message! "+m.toString());
                })
                .match(GetResaultMessage.class, req -> {
                    sender().tell(
                            new ResultsMessage(req.getID(), store.get(req.getID())), self());
                        }
                ).build();
    }
}
