package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.List;

public class PostRequestBody {

    public String packageId;

    public String JsScript;

    public String functionName;

    public List<Test> tests;
 }
