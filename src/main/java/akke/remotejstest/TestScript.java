package akke.remotejstest;

public class TestScript {
    public String functionBody, functionName;
    public Object[] params;
    public int packageID;
    TestScript(String packageID,String functionName, String functionBody, Object[] params){
        this.packageID = Integer.parseInt(packageID);
        this.functionName = functionName;
        this.functionBody = functionBody;
        this.params = params;
    }
}
