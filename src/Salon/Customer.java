package Salon;


public class Customer {

    String PhoneNo;
    String email;

    public Customer() {

    }

    public Customer(String PhoneNo, String email) {
        this.PhoneNo = PhoneNo;
        this.email = email;
    }

    public Customer createAccount(String FName, String LName, String password, String PhoneNo, String Email, String address) throws ExsistedAccountException {
        IOFile file = new IOFile();
        if (file.checkExistence(PhoneNo)) {
            throw new ExsistedAccountException();
        }
        file.createAccount(FName, LName, password, PhoneNo, Email, address);
        return getCustomer(PhoneNo, password);

    }

    public static Customer getCustomer(String PhoneNo, String pass) {
       return Customer.getCustomer(PhoneNo, pass);
    }
}
