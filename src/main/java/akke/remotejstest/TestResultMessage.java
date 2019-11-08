package akke.remotejstest;

public class StoreTestResultMessage {
    private String ID, result;
    StoreTestResultMessage(String ID, String result){
        this.ID=ID;
        this.result = result;
    }
    public String getID() {
        return ID;
    }
    public String getResult() {
        return result;
    }
    @Override
    public String toString(){
        return ID+" : "+ result;
    }
}
