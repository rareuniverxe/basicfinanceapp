import java.time.LocalDateTime;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionService {
    public void addTransaction(Scanner sc) {
        System.out.println("Enter the Amount?");
        Double transactionAmount = sc.nextDouble();
        sc.nextLine();
        System.out.println("IS THIS AN EXPENSE or INCOME?");
        String transactionType = sc.nextLine();
        System.out.println("What's the Category?");
        String transactionCategory = sc.nextLine();
        LocalDateTime time = LocalDateTime.now();
        Transaction t = new Transaction(0, transactionAmount, transactionType, transactionCategory, time);
        insertTransactionToDB(t);
    }

    public void insertTransactionToDB(Transaction t) {
        String url = "jdbc:sqlite:financeapp.db";
        String sql = "INSERT INTO transactions(amount, type, category, timestamp) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, t.getAmount());
            pstmt.setString(2, t.getType());
            pstmt.setString(3, t.getCategory());
            pstmt.setString(4, t.getTimeStamp().toString());

            pstmt.executeUpdate();
            System.out.println("Transaction inserted into database.");
        } catch (Exception e) {
            System.out.println("DB Insert Error: " + e.getMessage());
        }
    }
}
