package Domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 */
public class Insurance {
    private int insuranceID;
    private String insuranceName;
    private BigDecimal basePrice;
    private BigDecimal pricePerWeek;
    private String description;
    private DateFormat insuranceDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    public Insurance(int insuranceID, String insuranceName, BigDecimal basePrice, BigDecimal pricePerWeek, String description, DateFormat insuranceDate) {
        this.insuranceID = insuranceID;
        this.insuranceName = insuranceName;
        this.basePrice = basePrice;
        this.pricePerWeek = pricePerWeek;
        this.description = description;
        this.insuranceDate = insuranceDate;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getPricePerWeek() {
        return pricePerWeek;
    }

    public void setPricePerWeek(BigDecimal pricePerWeek) {
        this.pricePerWeek = pricePerWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(DateFormat insuranceDate) {
        this.insuranceDate = insuranceDate;
    }
}
