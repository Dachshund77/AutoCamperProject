package Domain;

import javafx.scene.input.DataFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AutoCamperType {
    private int autoCamperTypeID;
    private String categoryName;
    private BigDecimal weeklyPriceInSeason;
    private BigDecimal weeklyPriceOffSeason;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    public AutoCamperType(int autoCamperTypeID, String categoryName, BigDecimal weeklyPriceInSeason, BigDecimal weeklyPriceOffSeason, DateFormat dateFormat) {
        this.autoCamperTypeID = autoCamperTypeID;
        this.categoryName = categoryName;
        this.weeklyPriceInSeason = weeklyPriceInSeason;
        this.weeklyPriceOffSeason = weeklyPriceOffSeason;
        this.dateFormat = dateFormat;
    }

    public int getAutoCamperTypeID() {
        return autoCamperTypeID;
    }

    public void setAutoCamperTypeID(int autoCamperTypeID) {
        this.autoCamperTypeID = autoCamperTypeID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getWeeklyPriceInSeason() {
        return weeklyPriceInSeason;
    }

    public void setWeeklyPriceInSeason(BigDecimal weeklyPriceInSeason) {
        this.weeklyPriceInSeason = weeklyPriceInSeason;
    }

    public BigDecimal getWeeklyPriceOffSeason() {
        return weeklyPriceOffSeason;
    }

    public void setWeeklyPriceOffSeason(BigDecimal weeklyPriceOffSeason) {
        this.weeklyPriceOffSeason = weeklyPriceOffSeason;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
