package akke.remotejstest;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class ResultsMessage {
    private String key;
    private List<String> resaults;
    ResultsMessage(String key, List<String> resaults){
        this.key=key;
        this.resaults=resaults;
    }

    public String getKey() {
        return key;
    }
    public List<String> getResaults(){
        return resaults;
    }
}
