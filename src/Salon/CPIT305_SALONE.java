package Salon;

import java.io.IOException;

public class CPIT305_SALONE {

    public static void main(String[] args) throws IOException, ExsistedAccountException {
        Customer c = new Customer();
        IOFile f = new IOFile();
        f.createAccount("renad", "1234567", "1234567", "0500560751", "renad234@gmail.com", "almanar zead bin saad 707");
//        c.createAccount("renad", "1234567", "1234567", "0500560751", "renad234@gmail.com", "almanar zead bin saad 707");
    }
}
