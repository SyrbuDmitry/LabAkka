package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    public String testName;
    Test(@JsonProperty("testName") String testName){
        this.testName = testName;
    }
}
