package Salon;

import java.io.IOException;

public class Customer {

    String username;
    String email;

    public Customer() {

    }

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Customer createAccount(String username, String password, String repassword, String phonrnumber, String Email, String address) throws ExsistedAccountException, IOException {
//        DB db = new DB();
        IOFile fileDB = new IOFile();
        if (db.checkifExist(username) || fileDB.checkifExist(username)) {
            throw new ExsistedAccountException();
        }

        db.createAccount(username, password, repassword, phonrnumber, Email, address);
        fileDB.createAccount(username, password, repassword, phonrnumber, Email, address);

        return getCustomer(phonrnumber, password);
     
    }

    public static Customer getCustomer(String username, String pass) {
        DB db = new DB();
        return db.getStudent(username, pass);
    }
}
