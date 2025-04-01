import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void initialize() {
        try (Connection conn = DatabaseConnection.connect();
             Statement st = conn.createStatement()) {
            String sql = """
                CREATE TABLE IF NOT EXISTS transactions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    amount REAL NOT NULL,
                    category TEXT NOT NULL,
                    type TEXT NOT NULL,
                    timestamp TEXT NOT NULL
                )
                """;
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error setting up database: " + e.getMessage());
        }
    }
}
