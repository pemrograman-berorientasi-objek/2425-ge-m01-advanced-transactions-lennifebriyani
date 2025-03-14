package fintech.model;

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Transaction {
    private int id;
    private String owner;
    private String accountName;
    private double amount = 0.0;
    private String postedAt;
    private String note;

    public Transaction(int id, String owner, String accountName, double amount, String postedAt, String note) {
        this.id = id;
        this.owner = owner;
        this.accountName = accountName;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountName() {
        return accountName;
    }

@Override
public String toString() {
    return id + "|" + accountName + "|" + amount + "|" + postedAt + "|" + note;
    }
}