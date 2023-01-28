package Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Customer {
    String FName;
    String PhoneNo;
    String email;

    public Customer() {

    }

    public Customer(String PhoneNo, String email) {
        this.PhoneNo = PhoneNo;
        this.email = email;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public static Customer createAccount(String FName, String LName, String password, String PhoneNo, String Email, String address) throws ExsistedAccountException {
        IOFile file = new IOFile();
        if (file.checkExistence(PhoneNo)) {
            throw new ExsistedAccountException();
        }else{
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Customer.txt"), true));
            pw.println(FName + "," + LName + "," + password + "," + PhoneNo + "," + Email + "," + address);
            pw.close();
        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());

        }
        }

        return getCustomer(PhoneNo, password);

    }
public static Customer getCustomer(String PhoneNo, String pass) {
        IOFile io = new IOFile();
        return io.getCustomer(PhoneNo, pass);
    }
}
