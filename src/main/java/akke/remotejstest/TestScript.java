package akke.remotejstest;

public class TestScript {
    public String functionBody, functionName;
    public int[] params;
    public int packageID;
    TestScript(int packageID,String functionName, String functionBody, int[] params){
        this.packageID = packageID;
        this.functionName = functionName;
        this.functionBody = functionBody;
        this.params = params;
    }
}
