package DB;

/**
 *
 * @author Razan Alshaikh
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database_connection {

    String URL = "jdbc:mysql://localhost:3306/salonapp?useSSL=false";
    String USERNAME = "C3A_3";
    String PASSWORD = "RJD@12345";
    Connection con1 = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;
    String sqlQuery = "";
    public String role;

    public Database_connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            System.out.println(" Exception in database connection class");
            Logger.getLogger(Database_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     public void close() {
        try {
            con1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
