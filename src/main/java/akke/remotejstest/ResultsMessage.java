package akke.remotejstest;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.List;

public class ResultsMessage {
    private int packageID;
    private List<String> testResults;
    ResultsMessage(int packageID, List<String> testResults){
        this.packageID=packageID;
        this.testResults=testResults;
    }

    public int getID() {
        return packageID;
    }
    public List<String> getResaults(){
        return testResults;
    }
}
