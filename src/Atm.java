import java.util.Map;
import java.util.Scanner;

public class Atm {
    private Scanner scanner;

    public void menu() {
        scanner = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("Welcome to the ATM Java");
        System.out.println("===========================\n");
        System.out.println("Please enter your account number and password: ");
        System.out.print("Account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Account account = new Account(accountNumber, password);
        Map.Entry<String, Boolean> userLogin = account.login();
        if (!userLogin.getValue()) {
            System.out.println(userLogin.getKey());
            return;
        }
        System.out.println(userLogin.getKey());
        while (true) {
            System.out.flush();
            System.out.println("===========================");
            System.out.println("Menu ATM Java Bank");
            System.out.println("===========================\n");
            System.out.println("Please select an option: ");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Your account balance is: " + account.getBalance() + "\n");
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    String deposit = account.deposit(depositAmount);
                    System.out.println(deposit + "\n");
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    String withdraw = account.withdraw(withdrawAmount);
                    System.out.println(withdraw + "\n");
                    break;

                case 4:
                    System.out.println("Thank you for using ATM Java Bank");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
