package akke.remotejstest;

public class GetResultMessage {
    private int packageID;

    GetResultMessage(int id){
        this.packageID = id;
    }

    public int getID() {
        return packageID;
    }
}
