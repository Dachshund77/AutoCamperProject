package Domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Fee {
    private int feeID;
    private String name;
    private BigDecimal amount;
    private DateFormat feeDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    public Fee(int feeID, String name, BigDecimal amount, DateFormat feeDate) {
        this.feeID = feeID;
        this.name = name;
        this.amount = amount;
        this.feeDate = feeDate;
    }

    public int getFeeID() {
        return feeID;
    }

    public void setFeeID(int feeID) {
        this.feeID = feeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DateFormat getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(DateFormat feeDate) {
        this.feeDate = feeDate;
    }
}
