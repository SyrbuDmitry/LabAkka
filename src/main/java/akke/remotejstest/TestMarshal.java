package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMarshal {
    @JsonProperty("packageId")
    public String packageId;
    @JsonProperty("jsScript")
    public String jsScript;
}
