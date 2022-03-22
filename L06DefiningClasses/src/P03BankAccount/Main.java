package P03BankAccount;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new HashMap<>();

        String command = scan.nextLine();
        int ix = 1;
        while (!"End".equals(command)) {
            executeCommand(accounts, ix++, command);
            command = scan.nextLine();
        }
    }

    private static int executeCommand(Map<Integer, BankAccount> accounts, int ix, String command) {
        String[] tokens = command.split("\\s+");
        switch (tokens[0]) {
            case "Create":
                BankAccount account = new BankAccount();
                accounts.putIfAbsent(account.getId(), account);
                System.out.printf("Account ID%d created%n", account.getId());
                break;
            case "Deposit":
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                if (accounts.containsKey(id)) {
                    accounts.get(id).deposit(amount);
                    System.out.printf("Deposited %s to ID%d%n",amount, id);
                } else {
                    System.out.println("Account does not exist");
                }
                break;
            case "SetInterest":
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRare(interest);
                break;
            case "GetInterest":
                id = Integer.parseInt(tokens[1]);
                if (accounts.containsKey(id)) {
                    int years = Integer.parseInt(tokens[2]);
                    System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
                break;
        }
        return ix;
    }
}
