package akke.remotejstest;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class StoreTestResault {
    private String ID, resault;
    StoreTestResault(String ID,String resault){
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
