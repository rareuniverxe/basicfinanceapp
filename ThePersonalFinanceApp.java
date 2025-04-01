public class ThePersonalFinanceApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Personal Finance App");
        System.out.println();
        try {
            DatabaseSetup.initialize();
        } catch (Exception e) {
            System.out.println("Error during database setup: " + e.getMessage());
        }
        try {
            new FinanceManager().start();
        } catch (Exception e) {
            System.out.println("Error while starting the application: "+e.getMessage());
        }
    }
}
 