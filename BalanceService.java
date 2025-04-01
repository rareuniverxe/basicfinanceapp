import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class BalanceService {

    public void totalBalance() {
        double incomeAmount = 0;
        double expenseAmount = 0;
        try (Connection conn = DatabaseConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT type, amount FROM transactions")) {
            while (rs.next()) {
                if (rs.getString("type").equalsIgnoreCase("income")) {
                    incomeAmount = incomeAmount + rs.getDouble("amount");
                }
                if (rs.getString("type").equalsIgnoreCase("expense")) {
                    expenseAmount = expenseAmount + rs.getDouble("amount");
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching balance: " + e.getMessage());
        }
        System.out.println("---------------------------");
        System.out.printf("Total Income   : $%.2f%n", incomeAmount);
        System.out.printf("Total Expenses : $%.2f%n", expenseAmount);
        System.out.println("---------------------------");
        System.out.printf("Net Balance    : $%.2f%n", (incomeAmount - expenseAmount));
        System.out.println();
    }

}