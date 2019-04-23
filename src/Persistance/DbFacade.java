package Persistance;

import Domain.*;
import Foundation.DB;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;

public class DbFacade {

    public static Customer getCustomerByID(){ //TODO needs implementation
        return null;
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
    }

    public static void addAutoCamperToDB(ArrayList<AutoCamper> autoCampers){ //TODO needs implementation

    }

    public static void addReservationToDB(ArrayList<Reservation> reservations){ //TODO needs implementation

    }

    public static void addCustomerToDB(ArrayList<Customer> customers){ //TODO needs implementation

    }

    public static void addBillToDB(ArrayList<Bill> bill){ //TODO needs implementation

    }


    private static ArrayList<AutoCamper> BuildAutoCampers(ArrayList<Object[]> arrayList){
        ArrayList<AutoCamper> returnArrayList = new ArrayList<>();
        for (Object[] objects : arrayList) {
            AutoCamper tempAutoCamper = new AutoCamper((int)objects[0],
                    (String)objects[1],
                    null,
                    (int)objects[3],
                    (int)objects[4],
                    (int) objects[5],
                    (int) objects[6],
                    (int) objects[7],
                    (int) objects[8],
                    (String) objects[9],
                    (int) objects[10],
                    (String) objects[11],
                    (String) objects[12],
                    (String) objects[13],
                    (String) objects[14],
                    (String) objects[15],
                    null);
            // Attaching the AutoCamperType
            AutoCamperType type = BuildAutoCamperType((int)objects[2]);
            tempAutoCamper.setAutoCamperType(type);
            // Attaching the Statuses
            ArrayList<AutoCamperStatus> statuses = BuildAutoCamperStatuses((int)objects[2]);
            tempAutoCamper.setAutoCamperStatuses(statuses);
            // Adding to return list
            returnArrayList.add(tempAutoCamper);
        }
        return returnArrayList;
    }

    private static AutoCamperType BuildAutoCamperType(int autoCamperID){
        ArrayList<Object[]> autoCamperTypeByID = DB.executeStoredProcedure("sp_GetAutoCamperTypeByID",autoCamperID);
        Object[] o = autoCamperTypeByID.get(0);
        return new AutoCamperType((int)o[0],(String)o[1],(BigDecimal)o[2],(BigDecimal)o[3],(DateFormat)o[4]);
    }

    private static ArrayList<AutoCamperStatus> BuildAutoCamperStatuses(int autoCamperID){
        ArrayList<AutoCamperStatus> returnArrayList = new ArrayList<>();
        ArrayList<Object[]> autoCamperStatusByID = DB.executeStoredProcedure("sp_GetAutoCamperStatusByID", autoCamperID);
        for (Object[] objects : autoCamperStatusByID) {
            AutoCamperStatus tempStatus = new AutoCamperStatus((String)objects[0]);
            returnArrayList.add(tempStatus);
        }
        return returnArrayList;
    }

}
