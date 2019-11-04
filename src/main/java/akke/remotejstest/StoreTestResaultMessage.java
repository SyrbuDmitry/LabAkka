package akke.remotejstest;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class StoreTestResaultMessage {
    private String ID, resault;
    StoreTestResaultMessage(String ID, String resault){
        this.ID=ID;
        this.resault=resault;
    }
    public String getID() {
        return ID;
    }
    public String getResault() {
        return resault;
    }
}
