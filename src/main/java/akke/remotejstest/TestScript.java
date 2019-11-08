package akke.remotejstest;

public class TestScript {
    public String functionBody, functionName,params;
    public int packageID;
    TestScript(int packageID,String functionName, String functionBody, String params){
        this.packageID = packageID;
        this.functionName = functionName;
        this.functionBody = functionBody;
        this.params = params;
    }
}
