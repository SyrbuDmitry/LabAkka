package akke.remotejstest;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class StoreTestResault {
    private String ID, value;
    StoreTestResault(String ID,String value){
        this.ID=ID;
        this.value=value;
    }
    public String getID() {
        return ID;
    }
    public String getValue() {
        return value;
    }
}
