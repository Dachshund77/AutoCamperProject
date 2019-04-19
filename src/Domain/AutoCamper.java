package Domain;

import java.util.ArrayList;

public class AutoCamper {
    private int autoCamperID;
    private String numberPlate;
    private AutoCamperType autoCamperType;
    private int heightInCm;
    private int lengthInCm;
    private int weightInKg;
    private int noOfBeds;
    private int noOfSeats;
    private int mileageInKm;
    private String engine;
    private int gears;
    private String typeOfGas;
    private String kitchenDescription;
    private String heatingDescription;
    private String mediaDescription;
    private String generalDescription;
    private ArrayList<AutoCamperStatus> autoCamperStatuses;

    public AutoCamper(int autoCamperID, String numberPlate, AutoCamperType autoCamperType, int heightInCm, int lengthInCm, int weightInKg, int noOfBeds, int noOfSeats, int mileageInKm, String engine, int gears, String typeOfGas, String kitchenDescription, String heatingDescription, String mediaDescription, String generalDescription, ArrayList<AutoCamperStatus> autoCamperStatuses) {
        this.autoCamperID = autoCamperID;
        this.numberPlate = numberPlate;
        this.autoCamperType = autoCamperType;
        this.heightInCm = heightInCm;
        this.lengthInCm = lengthInCm;
        this.weightInKg = weightInKg;
        this.noOfBeds = noOfBeds;
        this.noOfSeats = noOfSeats;
        this.mileageInKm = mileageInKm;
        this.engine = engine;
        this.gears = gears;
        this.typeOfGas = typeOfGas;
        this.kitchenDescription = kitchenDescription;
        this.heatingDescription = heatingDescription;
        this.mediaDescription = mediaDescription;
        this.generalDescription = generalDescription;
        this.autoCamperStatuses = autoCamperStatuses;
    }

    public int getAutoCamperID() {
        return autoCamperID;
    }

    public void setAutoCamperID(int autoCamperID) {
        this.autoCamperID = autoCamperID;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public AutoCamperType getAutoCamperType() {
        return autoCamperType;
    }

    public void setAutoCamperType(AutoCamperType autoCamperType) {
        this.autoCamperType = autoCamperType;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    public int getLengthInCm() {
        return lengthInCm;
    }

    public void setLengthInCm(int lengthInCm) {
        this.lengthInCm = lengthInCm;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getMileageInKm() {
        return mileageInKm;
    }

    public void setMileageInKm(int mileageInKm) {
        this.mileageInKm = mileageInKm;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public String getTypeOfGas() {
        return typeOfGas;
    }

    public void setTypeOfGas(String typeOfGas) {
        this.typeOfGas = typeOfGas;
    }

    public String getKitchenDescription() {
        return kitchenDescription;
    }

    public void setKitchenDescription(String kitchenDescription) {
        this.kitchenDescription = kitchenDescription;
    }

    public String getHeatingDescription() {
        return heatingDescription;
    }

    public void setHeatingDescription(String heatingDescription) {
        this.heatingDescription = heatingDescription;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public ArrayList<AutoCamperStatus> getAutoCamperStatuses() {
        return autoCamperStatuses;
    }

    public void setAutoCamperStatuses(ArrayList<AutoCamperStatus> autoCamperStatuses) {
        this.autoCamperStatuses = autoCamperStatuses;
    }
}