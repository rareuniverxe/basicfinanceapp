import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TransactionFilter {

    public void filterByCategory(Scanner sc) {
        System.out.println("Enter the category :");
        String category = sc.nextLine();
        boolean flag = true;
        int count = 0;
        double sum = 0;
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "SELECT * FROM transactions WHERE category = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                category = rs.getString("category");
                LocalDateTime timestamp = LocalDateTime.parse(rs.getString("timestamp"));

                Transaction transaction = new Transaction(id, amount, type, category, timestamp);

                System.out.println("Transaction ID: " + transaction.getId() + " Amount: $" + transaction.getAmount() + " Category: " + transaction.getCategory());
                flag = false;
                count++;
                sum = sum + transaction.getAmount();  
            }
            rs.close();
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("There are "+count+" transactions of "+ category+" category");
        System.out.println("Total :$"+sum+" in " +category+" Category");
        if(flag){
            System.out.println("No category found");
        }
    }


    public void filterByType(Scanner sc) {
        System.out.println("Enter the type :");
        String type = sc.nextLine();
        boolean flag = true;
        int count = 0;
        double sum = 0;
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "SELECT * FROM transactions WHERE type = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                type = rs.getString("type");
                String category = rs.getString("category");
                LocalDateTime timestamp = LocalDateTime.parse(rs.getString("timestamp"));

                Transaction transaction = new Transaction(id, amount, type, category, timestamp);

                System.out.println("Transaction ID: " + transaction.getId() + " Amount: $" + transaction.getAmount() + " Type: " + transaction.getType());
                flag = false;
                count++;
                sum = sum + transaction.getAmount();  
            }
            rs.close();
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("There are "+count+" transactions of "+ type+" type");
        System.out.println("Total :$"+sum+" in " +type+" type");
        if(flag){
            System.out.println("No such type found");
        }
    }

    public void filterByDate(Scanner sc) {
        System.out.println("Enter the start date in the format 'yyyy-MM-dd' :");
        String startDate = sc.nextLine();
        System.out.println("Enter the end date in the format 'yyyy-MM-dd' :");
        String endDate = sc.nextLine();
        boolean flag = true;
        int count = 0;
        double sum = 0;
        Connection conn = null;
        try {
            conn = DatabaseConnection.connect();
            String query = "SELECT * FROM transactions WHERE DATE(timestamp) BETWEEN ? AND ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                String category = rs.getString("category");
                LocalDateTime timestamp = LocalDateTime.parse(rs.getString("timestamp"));

                Transaction transaction = new Transaction(id, amount, type, category, timestamp);

                System.out.println("Transaction ID: " + transaction.getId() + " Amount: $" + transaction.getAmount() + " Date: " + transaction.getTimeStamp().toLocalDate());
                flag = false;
                count++;
                sum = sum + transaction.getAmount();  
            }
            rs.close();
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("There are " + count + " transactions between " + startDate + " and " + endDate);
        System.out.println("Total :$" + sum + " in date range");
        if(flag){
            System.out.println("No date found");
        }
    }
}
