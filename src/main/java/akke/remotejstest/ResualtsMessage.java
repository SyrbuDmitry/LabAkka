package akke.remotejstest;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class ResualtsMessage {
    private String key;
    private String resaults;
    ResualtsMessage(String key, String resaults){
        this.key=key;
        this.resaults=resaults;
    }

    public String getKey() {
        return key;
    }
}
