/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;
import java.sql.*;
/**
 *
 * @author mac
 */
public class Database {
     String URL = "jdbc:mysql://localhost:3306/salonapp?useSSL=false";
        String USERNAME = "C3A_3";
        String PASSWORD = "RJD@12345";
    Connection con = null;
    String sqlQuery = "";
    ResultSet resultSet = null;
    PreparedStatement preparedstat = null;

    public  Database() {
      try {
           con = DriverManager.getConnection(URL,  USERNAME, PASSWORD);
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
      public boolean checkifExist(String PhoneNo) {

         sqlQuery = "SELECT * FROM customers where PhoneNo='" + PhoneNo + "';";
        try {
            PreparedStatement PreparedStmt = con.prepareStatement(sqlQuery);
            ResultSet rs = PreparedStmt.executeQuery(sqlQuery);
            if (rs != null && rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public int dropTable(){
     sqlQuery="DROP TABLE customers" ; 
     int i=0;
     
      try {
            preparedstat = con.prepareStatement(sqlQuery);
            i = preparedstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
  public int creatTable(){
    sqlQuery="CREATE TABLE customers(Fname VARCHAR(50) NOT NULL,Lname VARCHAR(50) NULL,"
            + "password VARCHAR(45) NOT NULL,"
            + "PhoneNo INT NOT NULL,email VARCHAR(50) NOT NULL,"
            + "address VARCHAR(50) NULL,PRIMARY KEY (PhoneNo))";
      int i = -1;

        try {
            Statement statement = con.createStatement();
            i = statement.executeUpdate(sqlQuery);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return i;
    
  }  
    
    public int insertRecord(String Fname, String Lname, String password, String PhoneNo, String email, String address) {
        sqlQuery = "INSERT INTO customers(Fname, Lname,password,PhoneNo,email,address) VALUES('" +  Fname + "','" + Lname + "','" + password  + "','" + PhoneNo + "','" + email + "','" + address +"');";
        int i = -1;

        try {
            Statement statement = con.createStatement();
            i = statement.executeUpdate(sqlQuery);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return i;
 }

    public ResultSet ShowAllRecords() {
        sqlQuery = "SELECT * FROM customers;";
        try {
            preparedstat = con.prepareStatement(sqlQuery);
            resultSet = preparedstat.executeQuery();
        } catch (SQLException e) {
        }
        return resultSet;
    }
   
}


