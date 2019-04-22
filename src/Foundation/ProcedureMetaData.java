package Foundation;

public class ProcedureMetaData {
    private int position;
    private String dataType;

    public ProcedureMetaData() {
    }

    public ProcedureMetaData(int position, String dataType) {
        this.position = position;
        this.dataType = dataType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}

