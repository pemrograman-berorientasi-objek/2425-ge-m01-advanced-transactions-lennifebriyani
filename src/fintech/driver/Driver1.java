package fintech.driver;

import fintech.model.Account;
import fintech.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        do {
            String command = scanner.nextLine();
            if (command.equals("---")) {
                break;
            }
            commands.add(command);
        } while (true);

        for (String command : commands) {
            String[] commandArgs = command.split("#");

            switch (commandArgs[0]) {
                case "create-account":
                    boolean isDuplicate = false;
                    for (Account accountObject : accounts) {
                        if (accountObject.getAccountName().equals(commandArgs[2])) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (!isDuplicate) {
                        Account account = new Account(commandArgs[1], commandArgs[2]);
                        accounts.add(account);
                        System.out.println(account);
                    }
                    break;
                    
                case "find-account":
                    for (Account accountObject : accounts) {
                        if (accountObject.getAccountName().equals(commandArgs[1].trim().toLowerCase())) {
                            System.out.println(accountObject);
                            break;
                        }  
                    }
                    break;

                case "create-transaction":
                boolean isDeficit = false;
                for (Account accountObject : accounts) {
                    if (accountObject.getAccountName().equals(commandArgs[1])) {
                        Transaction transaction = new Transaction(transactions.size() + 1,
                                accountObject.getOwner(),
                                accountObject.getAccountName(),
                                Double.parseDouble(commandArgs[2]),
                                commandArgs[3], commandArgs[4]);
                        double newBalance = accountObject.getBalance() + Double.parseDouble(commandArgs[2]);
                        if (newBalance >= 0) {
                            transactions.add(transaction);
                            accountObject.updateBalance(Double.parseDouble(commandArgs[2]));
                        } else {
                            isDeficit = true;
                        }
                        break;
                    }
                }
                if (!isDeficit) {
                }
                break;
                
                case "show-account":
                    List<Transaction> sortedTransactions = new ArrayList<>();
                    for (Transaction transaction : transactions) {
                        if (transaction.getAccountName().equals(commandArgs[1])) {
                            sortedTransactions.add(transaction);
                        }
                    }
                    Collections.sort(sortedTransactions, Comparator.comparing(Transaction::getPostedAt));
                    for (Account accountObject : accounts) {
                        if (accountObject.getAccountName().equals(commandArgs[1])) {
                            System.out.println(accountObject);
                            break;
                        }
                    }
                    for (Transaction transaction : sortedTransactions) {
                        System.out.println(transaction);
                    }
                    break;
                case "show-accounts":
                    accounts.sort(Comparator.comparing(Account::getAccountName));
                    transactions.sort(Comparator.comparing(Transaction::getPostedAt));
                    for (Account accountObject : accounts) {
                        System.out.println(accountObject);
                        for (Transaction transaction : transactions) {
                            if (transaction.getAccountName().equals(accountObject.getAccountName())) {
                                System.out.println(transaction);
                            }
                        }
                    }
                    break;
                case "remove-account":
                    Account account = null;
                    for(Account accountObject : accounts) {
                        if(accountObject.getAccountName().equalsIgnoreCase(commandArgs[1])) {
                            account = accountObject;
                            break;
                        }
                    }
                    if(account != null) {
                        accounts.remove(account);
                    }

            }
        }
    }
}