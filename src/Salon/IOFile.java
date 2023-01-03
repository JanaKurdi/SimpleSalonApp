package Salon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class IOFile {

    public boolean checkExistence(String PhoneNo) {
        try {
            Scanner inputfile = new Scanner(new File("Customer.txt"));
            while (inputfile.hasNext()) {
                String[] line = inputfile.nextLine().split(",");
                if (line[3].equals(PhoneNo)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public Customer getCustomer(String PhoneNo, String password) {
        try {
            Scanner inputfile = new Scanner(new File("Customer.txt"));
            while (inputfile.hasNext()) {
                String[] line = inputfile.nextLine().split(",");
                if (line[2].equals(password) && line[3].equals(PhoneNo)) {
                    return new Customer(line[2], line[3]);
                }
            }
        } catch (FileNotFoundException e) {
        }
        return null;

    }


    
    
}
