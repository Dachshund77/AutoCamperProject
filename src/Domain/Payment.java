package Domain;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private int paymentID;
    private Date paymentDate;
    private BigDecimal amount;
    private Bill billID;

    public Payment(int paymentID, Date paymentDate, BigDecimal amount, Bill billID) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.billID = billID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bill getBillID() {
        return billID;
    }

    public void setBillID(Bill billID) {
        this.billID = billID;
    }
}
