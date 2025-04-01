import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.ResultSet;

public class transactionsViewer {

    // public void viewTransaction(List<Transaction> transactionsList) {
    //     for(Transaction transaction: transactionsList) {
    //         System.out.println("----------------------------------------");
    //         System.out.println("Amount     : $" + transaction.getAmount());
    //         System.out.println("Type       : " + transaction.getType());
    //         System.out.println("Category   : " + transaction.getCategory());
    //         System.out.println("Timestamp  : " + transaction.getTimeStamp().format(DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm:ss a")));
    //         System.out.println("----------------------------------------");
    //     }
    // }

    public void viewTransaction() {
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM transactions");
            while(rs.next()) {
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                String category = rs.getString("category");
                LocalDateTime timestamp = LocalDateTime.parse(rs.getString("timestamp"));
                int id = rs.getInt("id");
                Transaction transaction = new Transaction(id, amount, type, category, timestamp);

        System.out.println("----------------------------------------");
        System.out.println("ID         : " + rs.getInt("id"));
        System.out.println("Amount     : $" + transaction.getAmount());
        System.out.println("Type       : " + transaction.getType());
        System.out.println("Category   : " + transaction.getCategory());
        System.out.println("Timestamp  : " + transaction.getTimeStamp().format(DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm:ss a")));
        System.out.println("----------------------------------------");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
