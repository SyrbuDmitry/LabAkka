package akke.remotejstest;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class ResultMessage {
    private String packageID;
    private List<String> results;
    ResultMessage(String key, List<String> results){
        this.key=key;
        this.results=results;
    }

    public String getKey() {
        return key;
    }
    public List<String> getResaults(){
        return results;
    }
}
