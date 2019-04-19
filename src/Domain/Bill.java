package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private int billID;
    private Date dueDate;
    private Discount discountID;
    private BillStatus billStatus;
    private ArrayList<Insurance> insurances;
    private ArrayList<Fee>fees;

    public Bill(int billID, Date dueDate, Discount discountID, BillStatus billStatus, ArrayList<Insurance> insurances, ArrayList<Fee> fees) {
        this.billID = billID;
        this.dueDate = dueDate;
        this.discountID = discountID;
        this.billStatus = billStatus;
        this.insurances = insurances;
        this.fees = fees;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Discount getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Discount discountID) {
        this.discountID = discountID;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public ArrayList<Fee> getFees() {
        return fees;
    }

    public void setFees(ArrayList<Fee> fees) {
        this.fees = fees;
    }
}
