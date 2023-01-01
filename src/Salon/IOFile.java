package Salon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOFile {

    public boolean checkifExist(String username) {
        try {
            FileReader fr = new FileReader(new File("Customer.txt"));
            while (fr.ready()) {
                String[] line = fr.toString().split(",");
                if (line[0].equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public Customer getCustomer(String phonrnumber, String password) {
        try {
            Scanner inputfile = new Scanner(new File("Customer.txt"));
            while (inputfile.hasNext()) {
                String[] line = inputfile.nextLine().split(",");
                if (line[1].equals(password) && line[3].equals(phonrnumber)) {
                    return new Customer(line[1], line[3]);
                }
            }
        } catch (Exception e) {
        }
        return null;

    }

    public boolean createAccount(String username, String password, String repassword, String phonrnumber, String Email, String address) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Customer.txt"), true));
            pw.println(username + "," + password + "," + repassword + "," + phonrnumber + "," + Email + "," + address);
            pw.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
