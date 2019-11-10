package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMarshal {
    @JsonProperty("packageId")
    private String packageId;
    @JsonProperty("jsScript")
    private String jsScript;
}
