import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        AtmOperationsInterface op = new AtmOperations();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ATM Machine!");
        System.out.println("Enter Atm number: ");
        String input = sc.next();
        System.out.println("Enter Atm pin: ");
        String pin = sc.next();
        int intInputValue = 0;
        do {
            try {

                intInputValue = Integer.parseInt(input);
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View history\n5.Exit");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        op.viewBalance();
                        break;

                    case 2:
                        System.out.println("Enter amount to withdraw ");
                        double withdrawAmount = sc.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter Amount to Deposit : ");
                        double depositAmount = sc.nextDouble();
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        op.viewHistory();
                        break;
                    case 5:
                        System.out.println("Collect your ATM card.\nThank you for using ATM machine");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter correct choice!");
                }
            } catch (NumberFormatException ne) {
                System.out.println("Incorrect Atm number or pin");
                System.exit(0);
            }
        }
        while (true);
    }
}

