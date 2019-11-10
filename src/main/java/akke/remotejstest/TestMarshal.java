package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMarshal {
    String packageId;
    String jsScript;
    @JsonCreator
    public TestMarshal(@JsonProperty("packageID") String id, @JsonProperty("jsScript") String name) {
        this.packageId = id;
        this.jsScript = name;
    }
}
