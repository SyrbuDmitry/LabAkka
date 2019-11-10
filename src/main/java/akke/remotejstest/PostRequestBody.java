package akke.remotejstest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Array;
import java.util.List;

public class PostRequestBody {

    public String packageId;

    public String JsScript;

    public String functionName;
    @XmlElement(name = "tests")
    public List<Test> tests;
    PostRequestBody(){
    }
 }
