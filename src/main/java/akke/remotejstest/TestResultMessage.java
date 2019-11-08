package akke.remotejstest;

public class TestResultMessage {
    private String testResult;
    private int packageID;
    TestResultMessage(int packageID, String testResult){
        this.packageID=packageID;
        this.testResult = testResult;
    }
    public int getID() {
        return packageID;
    }
    public String getResult() {
        return testResult;
    }
    @Override
    public String toString(){
        return packageID+" : "+ testResult;
    }
}
