package by.jwdc.finances.bean;

public class OperationType {

    private String name;
    private boolean inComeOperation;

    public OperationType() {
    }

    public OperationType(String name, boolean inComeOperation) {
        this.name = name;
        this.inComeOperation = inComeOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInComeOperation() {
        return inComeOperation;
    }

    public void setInComeOperation(boolean inComeOperation) {
        this.inComeOperation = inComeOperation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        OperationType operationType = (OperationType)obj;
        return (this.inComeOperation == operationType.inComeOperation) &&
                this.name.equals(operationType.name);
    }

    @Override
    public int hashCode() {
        int res = 7;
        int prime = 31;

        res = res * prime + this.name == null ? 0 : name.hashCode();
        res = res * prime + (this.inComeOperation ? 1 : 0);


        return res;
    }

    @Override
    public String toString() {
        return "OperationType{" +
                "name='" + name +
                ", isInComeOperation=" + inComeOperation +
                '}';
    }
}
