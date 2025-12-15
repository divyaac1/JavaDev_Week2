package service;

import service.BankService;
import model.Account;
import persistence.FileRepository;
import java.io.File;
import java.util.Map;

public class TestBanking {
    public static void main(String[] args) {
        System.out.println("Running Automated Tests...");

        // Clean up previous test data
        File file = new File("accounts.txt");
        if (file.exists()) {
            file.delete();
        }

        BankService service = new BankService();

        // Test 1: Create Savings Account
        service.createSavingsAccount("SA001", "Alice", 1000.0, 2.5);
        System.out.println("Test 1 (Create Savings): Done");

        // Test 2: Create Current Account
        service.createCurrentAccount("CA001", "Bob", 500.0, 1000.0);
        System.out.println("Test 2 (Create Current): Done");

        // Test 3: Deposit
        service.deposit("SA001", 500.0); // Balance should be 1500
        System.out.println("Test 3 (Deposit): Done");

        // Test 4: Withdraw
        service.withdraw("SA001", 200.0); // Balance should be 1300
        System.out.println("Test 4 (Withdraw): Done");

        // Test 5: Withdraw with Overdraft
        service.withdraw("CA001", 600.0); // Balance should be -100 (allowed)
        System.out.println("Test 5 (Overdraft Withdraw): Done");

        // Verify Data Persistence
        System.out.println("Verifying Persistence...");
        FileRepository repo = new FileRepository();
        Map<String, Account> accounts = repo.loadAccounts();

        if (accounts.containsKey("SA001") && accounts.get("SA001").getBalance() == 1300.0) {
            System.out.println("PASS: Savings Account Balance Verified");
        } else {
            System.out.println("FAIL: Savings Account Balance Incorrect");
        }

        if (accounts.containsKey("CA001") && accounts.get("CA001").getBalance() == -100.0) {
            System.out.println("PASS: Current Account Balance Verified");
        } else {
            System.out.println("FAIL: Current Account Balance Incorrect");
        }
    }
}
