package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private int seasonID;
    private Date startDate;
    private Date endDate;
    private int mileAgeAtDeparture;
    private int mileAgeAtArrival;
    private AutoCamper autoCamper;
    private Season season;
    private ArrayList<Customer> customers;

    public Reservation(int seasonID, Date startDate, Date endDate, int mileAgeAtDeparture, int mileAgeAtArrival, AutoCamper autoCamper, Season season, ArrayList<Customer> customers) {
        this.seasonID = seasonID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mileAgeAtDeparture = mileAgeAtDeparture;
        this.mileAgeAtArrival = mileAgeAtArrival;
        this.autoCamper = autoCamper;
        this.season = season;
        this.customers = customers;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMileAgeAtDeparture() {
        return mileAgeAtDeparture;
    }

    public void setMileAgeAtDeparture(int mileAgeAtDeparture) {
        this.mileAgeAtDeparture = mileAgeAtDeparture;
    }

    public int getMileAgeAtArrival() {
        return mileAgeAtArrival;
    }

    public void setMileAgeAtArrival(int mileAgeAtArrival) {
        this.mileAgeAtArrival = mileAgeAtArrival;
    }

    public AutoCamper getAutoCamper() {
        return autoCamper;
    }

    public void setAutoCamper(AutoCamper autoCamper) {
        this.autoCamper = autoCamper;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
