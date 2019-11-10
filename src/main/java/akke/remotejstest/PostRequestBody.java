package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class PostRequestBody {
    public String packageId;
    public String JsScript;
    public String functionName;
    public List<Test> tests;
    @JsonCreator
    public PostRequestBody(@JsonProperty("packageId") String packageId,
                           @JsonProperty("jsScript") String JsScript,
                           @JsonProperty("functionName") String functionName,
                           @JsonProperty("tests") List<Test> tests){
        this.packageId = packageId;
        this.JsScript = JsScript;
        this.functionName = functionName;
        this.tests = tests;
    }
 }
