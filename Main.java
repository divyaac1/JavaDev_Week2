package service;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String sAccNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String sHolder = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double sDeposit = scanner.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double sInterest = scanner.nextDouble();
                    bankService.createSavingsAccount(sAccNum, sHolder, sDeposit, sInterest);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String cAccNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String cHolder = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double cDeposit = scanner.nextDouble();
                    System.out.print("Enter Overdraft Limit: ");
                    double cLimit = scanner.nextDouble();
                    bankService.createCurrentAccount(cAccNum, cHolder, cDeposit, cLimit);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String dAccNum = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double dAmount = scanner.nextDouble();
                    bankService.deposit(dAccNum, dAmount);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    String wAccNum = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double wAmount = scanner.nextDouble();
                    bankService.withdraw(wAccNum, wAmount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    String bAccNum = scanner.nextLine();
                    bankService.checkBalance(bAccNum);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
