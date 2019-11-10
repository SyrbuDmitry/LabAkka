package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    @JsonProperty("testName")
    public String testName;
    @JsonProperty("expectedResult")
    public String expectedResult;
    @JsonProperty("params")
    public String params;
}
