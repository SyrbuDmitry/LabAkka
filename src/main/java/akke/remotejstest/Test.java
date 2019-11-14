package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    public String testName;
    public String expectedResult;
    public Object[] params;
    Test(@JsonProperty("testName") String testName,
         @JsonProperty("expectedResult") String expectedResult,
         @JsonProperty("params") Object[] params){
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }
}
