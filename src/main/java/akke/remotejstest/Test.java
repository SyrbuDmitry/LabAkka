package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    public String testName;
    public String expectedResult;
    public String params;
    Test(@JsonProperty("testName") String testName){
        this.testName = testName;
    }
}
