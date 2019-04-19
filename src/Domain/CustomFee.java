package Domain;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CustomFee {
    private int customFeeID;
    private BigDecimal amount;
    private String name;
    private String comment;
    private Bill billID;
    private ArrayList<Reservation> reservations;

    public CustomFee(int customFeeID, BigDecimal amount, String name, String comment, Bill billID, ArrayList<Reservation> reservations) {
        this.customFeeID = customFeeID;
        this.amount = amount;
        this.name = name;
        this.comment = comment;
        this.billID = billID;
        this.reservations = reservations;
    }

    public int getCustomFeeID() {
        return customFeeID;
    }

    public void setCustomFeeID(int customFeeID) {
        this.customFeeID = customFeeID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bill getBillID() {
        return billID;
    }

    public void setBillID(Bill billID) {
        this.billID = billID;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
