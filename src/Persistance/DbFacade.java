package Persistance;

import Domain.*;
import Foundation.DB;

import java.util.ArrayList;
import java.util.Arrays;

public class DbFacade {

    // Get by ID
    public static Customer getCustomerByID() { //TODO needs implementation
        return null;
        // establish connection
        // Call procedure

        // Build logical structure (no duplicates)

        // close connection
    }

    public static AutoCamper getAutoCamperByID() { //TODO needs implementation
        return null;
    }

    public static Bill getBillByID() { //TODO needs implementation
        return null;
    }

    public static Reservation getReservationByID() { //TODO needs implementation
        return null;
    }

    //Get all of x

    /**
     * Method that will execute stored procedure sp_GetAllZips and build objects from it.
     * @return ArrayList of All Zips in DB
     */
    public static ArrayList<Zip> getAllZip() {
        ArrayList<Zip> returnArrayList = new ArrayList<>();
        // Getting raw data
        ArrayList<Object[]> rawData = DB.executeStoredProcedure("sp_GetAllZips");
        // Mapping the raw data names
        String[] columnNames = DB.getRsColumnNames();
        int fld_ZipIndex = Arrays.asList(columnNames).indexOf("fld_Zip");
        int fld_CityIndex = Arrays.asList(columnNames).indexOf("fld_City");
        // Building
        for (Object[] rawDatum : rawData) {
            Zip tempZip = buildZip(rawDatum,fld_ZipIndex,fld_CityIndex);
            returnArrayList.add(tempZip);
        }
        return returnArrayList;
    }

    public static ArrayList<Customer> getAllCustomer() { //TODO needs implementation
        return null;
    }

    public static ArrayList<AutoCamper> getAllAutoCampers() { //TODO needs implementation
        return null;
    }

    public static ArrayList<Reservation> getAllReservations() { //TODO needs implementation
        return null;
    }

    public static ArrayList<Bill> getAllBills() { //TODO needs implementation
        return null;
        // This will most likely not be used cause a bill ALWAYS has a reservation
    }

    //Returning to DB

    public static void addAutoCamperToDB(ArrayList<AutoCamper> autoCampers) { //TODO needs implementation

    }

    public static void addReservationToDB(ArrayList<Reservation> reservations) { //TODO needs implementation

    }

    public static void addCustomerToDB(ArrayList<Customer> customers) { //TODO needs implementation

    }

    public static void addBillToDB(ArrayList<Bill> bill) { //TODO needs implementation
        // This we might not use
    }

    //Dynamic search //TODO implement method

    // Deletion.... if we ever have time


    // Building classes from raw data

    /**
     * Helper class to build a Zip from raw Data
     * @param rawData Object array of raw data
     * @param zipIndex int index of fld_Zip in RawData
     * @param cityIndex int index of fld_City in RawData
     * @return zip Object
     */
    private static Zip buildZip(Object[] rawData, int zipIndex, int cityIndex) {
        String zip = (String) rawData[zipIndex];
        String city = (String) rawData[cityIndex];
        return new Zip(zip, city);
    }


    private static AutoCamper buildAutoCamper(Object[] o) { //TODO needs implementation
        // rsmd.getColumname to find the column
        //Store where it is
        // Accesing array and building an autocamper object
        return null;
    }

    private static AutoCamperType buildAutoCamperType(Object[] o) { //TODO needs implementation
        return null;
    }

    private static AutoCamperStatus buildAutoCamperStatuses(Object[] o) { //TODO needs implementation
        return null;
    }


}
