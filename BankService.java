package service;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import persistence.FileRepository;

import java.util.Map;

public class BankService {
    private Map<String, Account> accounts;
    private FileRepository repository;

    public BankService() {
        this.repository = new FileRepository();
        this.accounts = repository.loadAccounts();
    }

    public void createSavingsAccount(String accountNumber, String holderName, double initialDeposit,
            double interestRate) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        Account account = new SavingsAccount(accountNumber, holderName, initialDeposit, interestRate);
        accounts.put(accountNumber, account);
        save();
        System.out.println("Savings Account created successfully.");
    }

    public void createCurrentAccount(String accountNumber, String holderName, double initialDeposit,
            double overdraftLimit) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        Account account = new CurrentAccount(accountNumber, holderName, initialDeposit, overdraftLimit);
        accounts.put(accountNumber, account);
        save();
        System.out.println("Current Account created successfully.");
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            save();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            save();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Holder: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Type: " + account.getType());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void save() {
        repository.saveAccounts(accounts);
    }
}
