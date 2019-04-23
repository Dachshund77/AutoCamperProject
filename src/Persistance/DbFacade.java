package Persistance;

import Domain.*;

import java.util.ArrayList;

public class DbFacade {

    // Get by ID
    public static Customer getCustomerByID(){ //TODO needs implementation
        return null;
        // establish connection
        // Call procedure

        // Build logical structure (no duplicates)

        // close connection
    }

    public static AutoCamper getAutoCamperByID(){ //TODO needs implementation
        return null;
    }

    public static Bill getBillByID(){ //TODO needs implementation
        return null;
    }

    public static Reservation getReservationByID(){ //TODO needs implementation
        return null;
    }

    //Get all of x

    public static ArrayList<Customer> getAllCustomer(){ //TODO needs implementation
        return null;
    }

    public static ArrayList<AutoCamper>  getAllAutoCampers(){ //TODO needs implementation
        return null;
    }

    public static ArrayList<Reservation> getAllReservations(){ //TODO needs implementation
        return null;
    }

    public static ArrayList<Bill> getAllBills(){ //TODO needs implementation
        return null;
        // This will most likely not be used cause a bill ALWAYS has a reservation
    }

    //Returning to DB

    public static void addAutoCamperToDB(ArrayList<AutoCamper> autoCampers){ //TODO needs implementation

    }

    public static void addReservationToDB(ArrayList<Reservation> reservations){ //TODO needs implementation

    }

    public static void addCustomerToDB(ArrayList<Customer> customers){ //TODO needs implementation

    }

    public static void addBillToDB(ArrayList<Bill> bill){ //TODO needs implementation
        // This we might not use
    }

    //Dynamic search //TODO implement method

    // Deletion.... if we ever have time


    // Building stuff

    private static AutoCamper BuildAutoCamper(Object[] o){ //TODO needs implementation
        // rsmd.getColumname to find the column
        //Store where it is
        // Accesing array and building an autocamper object
        return null;
    }

    private static AutoCamperType BuildAutoCamperType(Object[] o){ //TODO needs implementation
        return null;
    }

    private static AutoCamperStatus BuildAutoCamperStatuses(Object[] o){ //TODO needs implementation
        return null;
    }



}
