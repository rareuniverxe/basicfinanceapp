import java.util.Scanner;

public class FinanceManager {
    Scanner sc = new Scanner(System.in);

    public void start() {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                ===============================
                Personal Finance App - Main Menu
                ===============================
                1. Add an income or expense entry
                2. View all transactions
                3. View total balance
                4. Filter transactions
                5. Modify a transaction (Delete/Update)
                6. Exit the app
                -------------------------------
                Enter your choice:
                """);
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }
            int userInput = sc.nextInt();
            sc.nextLine();
            switch (userInput) {
                case 1:
                    new TransactionService().addTransaction(sc);
                    break;
                case 2:
                    new transactionsViewer().viewTransaction();
                    break;
                case 3:
                    new BalanceService().totalBalance();
                    break;
                case 4:
                    System.out.println("Enter 1 To Filter By Category \n 2. To Filter By Type \n 3. To filter by Date");
                    int userChoice = sc.nextInt();
                    sc.nextLine();
                    switch (userChoice) {
                        case 1:
                            new TransactionFilter().filterByCategory(sc);
                            break;
                        case 2:
                            new TransactionFilter().filterByType(sc);
                            break;
                        case 3:
                            // new TransactionFilter().filterByDate(sc);
                            break;
                        default:
                            System.out.println("Enter a valid input");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Enter 1 to Delete a transaction \n2 to Update a transaction");
                    int modifyChoice = sc.nextInt();
                    sc.nextLine();
                    switch (modifyChoice) {
                        case 1:
                        new TransactionModifier().deleteTransaction(sc);
                            break;
                        case 2:
                        new TransactionModifier().updateTransaction(sc);
                            break;
                        default:
                            System.out.println("Enter a valid input");
                            break;
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid input");
                    break;
            }
        }
        sc.close();
    }
}
