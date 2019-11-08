package akke.remotejstest;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
//import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.HashedMap;
//import org.apache.commons.collections4.map.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<Integer,List<String>> store = new HashedMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestResultMessage.class, m -> {
                    if(store.get(m.getID())!=null){
                        store.get(m.getID()).add(m.getResult());
                    }else{
                        List<String> resultString = new ArrayList<>();
                        resultString.add(m.getResult());
                        store.put(m.getID(), resultString);
                    }
                    System.out.println("receive message! "+m.toString());
                })
                .match(GetResaultMessage.class, req -> sender().tell(
                        new ResultsMessage(req.getID(), store.get(req.getID())), self())
                ).build();
    }
}
