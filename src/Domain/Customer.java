package Domain;

public class Customer {
    private int customerID;
    private String CustomerName;
    private String phoneNr;
    private String eMail;
    private Zip zip;
    private String address;

    public Customer(int customerID, String customerName, String phoneNr, String eMail, Zip zip, String address) {
        this.customerID = customerID;
        CustomerName = customerName;
        this.phoneNr = phoneNr;
        this.eMail = eMail;
        this.zip = zip;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Zip getZip() {
        return zip;
    }

    public void setZip(Zip zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
