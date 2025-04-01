import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:financeapp.db");
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }
}
