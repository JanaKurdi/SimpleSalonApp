package Salon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {

    String PhoneNo;
    String email;

    public Customer() {

    }

    public Customer(String PhoneNo, String email) {
        this.PhoneNo = PhoneNo;
        this.email = email;
    }

    public static Customer createAccount(String FName, String LName, String password, String PhoneNo, String Email, String address) throws ExsistedAccountException {
        IOFile file = new IOFile();
        if (file.checkExistence(PhoneNo)) {
            throw new ExsistedAccountException();
        }
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Customer.txt"), true));
            pw.println(FName + "," + LName + "," + password + "," + PhoneNo + "," + Email + "," + address);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getCustomer(PhoneNo, password);

    }

    public static Customer getCustomer(String PhoneNo, String pass) {
        IOFile io = new IOFile();
        return io.getCustomer(PhoneNo, pass);
    }
}

// the old one

//public Customer createAccount(String FName, String LName, String password, String PhoneNo, String Email, String address) throws ExsistedAccountException {
//	IOFile file = new IOFile();
//	if (file.checkExistence(PhoneNo)) {
//	throw new ExsistedAccountException();
//	}
//	file.createAccount(FName, LName, password, PhoneNo, Email, address);
//	return getCustomer(PhoneNo, password);
//	
//	}
//	
//	public static Customer getCustomer(String PhoneNo, String pass) {
//	return Customer.getCustomer(PhoneNo, pass);
//	}
//	}

