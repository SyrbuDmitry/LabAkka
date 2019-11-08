package akke.remotejstest;

public class TestScript {
    public String functionBody, functionName,params;
    TestScript(String functionName, String functionBody, String params){
        this.functionName = functionName;
        this.functionBody = functionBody;
        this.params = params;
    }
}
