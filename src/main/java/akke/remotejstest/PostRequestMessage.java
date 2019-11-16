package akke.remotejstest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class PostRequestMessage {
    public String packageId;
    public String JsScript;
    public String functionName;
    public List<Test> tests;
    @JsonCreator
    public PostRequestMessage(@JsonProperty("packageId") String packageId,
                              @JsonProperty("jsScript") String JsScript,
                              @JsonProperty("functionName") String functionName,
                              @JsonProperty("tests") List<Test> tests){
        this.packageId = packageId;
        this.JsScript = JsScript;
        this.functionName = functionName;
        this.tests = tests;
    }
 }
