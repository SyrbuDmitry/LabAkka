package akke.remotejstest;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class ResultsMessage {
    private String key;
    private String results;
    ResultsMessage(String key, String results){
        this.key=key;
        this.results=results;
    }

    public String getKey() {
        return key;
    }
    public String getResaults(){
        return results;
    }
}
