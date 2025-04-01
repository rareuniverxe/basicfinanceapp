import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TransactionModifier {
    public void deleteTransaction(Scanner sc){
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseConnection.connect();
            System.out.println("Enter the Id that you want to remove");
            String userInput = (sc.nextLine());

            String query = "DELETE FROM transactions WHERE id = ?";
            st = conn.prepareStatement(query);
            st.setString(1, userInput);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transaction deleted successfully.");
            } else {
                System.out.println("No transaction found with the given ID.");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void updateTransaction(Scanner sc){

        System.out.println("Enter 1 to update TYPE\nEnter 2 to update CATEGORY:");

        int userInput = sc.nextInt(); sc.nextLine();

        switch (userInput) {
            case 1:
                updateType(sc);
                break;
            case 2:
                updateCategory(sc);
            break;
            default:
            System.out.println("ENTER A VALID INPUT");
                break;
        }
    }

    public void updateType(Scanner sc){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnection.connect();
            System.out.println("Enter the Id which you want to update :");
            String id = sc.nextLine();
            System.out.println("Enter the new type :");
            String type = sc.nextLine();

            String query = "UPDATE transactions SET type = ? where id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, type);
            ps.setString(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transaction updated successfully.");
            } else {
                System.out.println("No transaction found with the given ID.");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void updateCategory(Scanner sc){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnection.connect();
            System.out.println("Enter the Id which you want to update :");
            String id = sc.nextLine();
            System.out.println("Enter the new Category :");
            String category = sc.nextLine();

            String query = "UPDATE transactions SET category = ? where id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, category);
            ps.setString(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transaction updated successfully.");
            } else {
                System.out.println("No transaction found with the given ID.");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
