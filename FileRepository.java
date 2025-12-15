package persistence;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileRepository {
    private static final String FILE_PATH = "accounts.txt";

    public void saveAccounts(Map<String, Account> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Account account : accounts.values()) {
                StringBuilder line = new StringBuilder();
                line.append(account.getType()).append(",")
                        .append(account.getAccountNumber()).append(",")
                        .append(account.getHolderName()).append(",")
                        .append(account.getBalance()).append(",");

                if (account instanceof SavingsAccount) {
                    line.append(((SavingsAccount) account).getInterestRate());
                } else if (account instanceof CurrentAccount) {
                    line.append(((CurrentAccount) account).getOverdraftLimit());
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving accounts: " + e.getMessage());
        }
    }

    public Map<String, Account> loadAccounts() {
        Map<String, Account> accounts = new HashMap<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return accounts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5)
                    continue;

                String type = parts[0];
                String accNum = parts[1];
                String holder = parts[2];
                double balance = Double.parseDouble(parts[3]);
                double specific = Double.parseDouble(parts[4]);

                Account account = null;
                if ("SAVINGS".equals(type)) {
                    account = new SavingsAccount(accNum, holder, balance, specific);
                } else if ("CURRENT".equals(type)) {
                    account = new CurrentAccount(accNum, holder, balance, specific);
                }

                if (account != null) {
                    accounts.put(accNum, account);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading accounts: " + e.getMessage());
        }
        return accounts;
    }

	public Map<String, Account> loadAccounts1() {
		// TODO Auto-generated method stub
		return null;
	}
}
