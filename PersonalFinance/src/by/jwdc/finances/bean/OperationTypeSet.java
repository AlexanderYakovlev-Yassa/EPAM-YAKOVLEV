package by.jwdc.finances.bean;

import java.io.Serializable;
import java.util.HashSet;

public class OperationTypeSet implements Serializable {

    private static final OperationTypeSet instance = new OperationTypeSet();

    private HashSet<OperationType> type;

    private OperationTypeSet() {
        this.type = new HashSet<OperationType>();
    }

    public static OperationTypeSet getInstance() {
        return instance;
    }

    public HashSet<OperationType> getType() {
        return type;
    }

    public boolean addType(OperationType newType){

        if (newType == null){
            return false;
        }

        return this.type.add(newType);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder("OperationType{type=[");

        for (OperationType o : this.type){
            res.append(o.getName() + "-" + o.isInComeOperation());
        }
        res.append("\b\b]}");

        return res.toString();
    }
}
