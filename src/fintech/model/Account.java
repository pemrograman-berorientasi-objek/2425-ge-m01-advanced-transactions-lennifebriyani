package fintech.model;

import java.util.ArrayList;
import java.util.List; 

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Account {
    private String owner;
    private String accountName;
    private double balance;

    public Account(String owner, String accountName) {
        this.owner = owner;
        this.accountName = accountName;
        this.balance = 0.0;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(accountName).append("|")
                .append(owner).append("|")
                .append(balance);
        return sb.toString();
    }
}