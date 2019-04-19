package Domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Discount {
    private int discountID;
    private int noOfRentals;
    private BigDecimal discountPercentage;
    private DateFormat discountDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    public Discount(int discountID, int noOfRentals, BigDecimal discountPercentage, DateFormat discountDate) {
        this.discountID = discountID;
        this.noOfRentals = noOfRentals;
        this.discountPercentage = discountPercentage;
        this.discountDate = discountDate;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public int getNoOfRentals() {
        return noOfRentals;
    }

    public void setNoOfRentals(int noOfRentals) {
        this.noOfRentals = noOfRentals;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public DateFormat getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(DateFormat discountDate) {
        this.discountDate = discountDate;
    }
}
