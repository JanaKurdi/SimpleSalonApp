package Client;

public class Customer {

    String username;
    String email;


    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

//    public static Customer createAccount(String username, String pass, String repass, String email) throws ExsistedAccountException {
//        DB db = new DB();
//        FileDB fileDB = new FileDB();
//        if (db.checkifExist(username) || fileDB.checkifExist(username)) {
//            throw new ExsistedAccountException();
//        }
//
//        db.createAccount(username, pass, email);
//        fileDB.createAccount(username, pass, email);
//
//        return getCustomer(username, pass);
//    }
//
//    public static Customer getCustomer(String username, String pass) {
//        DB db = new DB();
//        return db.getStudent(username, pass);
//    }

}
