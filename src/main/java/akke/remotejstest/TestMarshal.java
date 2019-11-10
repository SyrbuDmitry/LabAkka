package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMarshal {
    private final String packageId;
    private final String jsScript;
    @JsonCreator
    public TestMarshal(@JsonProperty("packageId") String id, @JsonProperty("jsScript") String name) {
        this.packageId = id;
        this.jsScript = name;
    }
}
