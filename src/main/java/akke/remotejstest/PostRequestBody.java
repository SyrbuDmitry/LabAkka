package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostRequestBody {
    @JsonProperty("packageId")
    public String packageId;
    @JsonProperty("JsScript")
    public String JsScript;
    @JsonProperty("functionName")
    public String functionName;
    @Json
    public List<Test> tests;
 }
