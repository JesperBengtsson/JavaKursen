import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private List<Transaction> transactionList = new ArrayList<>();
    private User user;
    private boolean locked = false;

    public BankAccount(User user, String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.user = user;
    }

    public boolean addMoney(double amount){
        if(amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdrawMoney(double amount) {
        if(this.balance - amount < 0 || amount <= 0) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public void listTransactions() {
        for(Transaction transaction : transactionList) {
            System.out.println(transaction.toString() + "\n");
        }
    }

    public void addToTransactionHistory(Transaction transaction) {
        transactionList.add(transaction);
    }

    public void accountAccess(BankAccount account) {
        if(!account.isLocked()) {
            System.out.println("Account is now locked for withdrawal.");
            account.setLocked(true);
        }
        else if(account.isLocked()) {
            System.out.println("Account has now access to withdrawal.");
            account.setLocked(false);
        }
    }



    // Getters and setters
    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public List<Transaction> getTransactions() {
        return transactionList;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + "\nOwner: " + user.getName() + "\nBalance: " + balance + "kr";
    }
}
