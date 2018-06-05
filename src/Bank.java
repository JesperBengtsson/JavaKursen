import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public void addAccount(User user, String accountNumber) {
        for(BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountNumber().equals(accountNumber)) {
                return;
            }
        }
         BankAccount newAccount = new BankAccount(user, accountNumber);
         bankAccounts.add(newAccount);
         user.addAccountId(newAccount);
    }

    public void printAllAccounts() {
        for(BankAccount bankAccount : bankAccounts) {
            System.out.println(bankAccount.toString() + "\n");
        }
    }

    public BankAccount getAccountByAccountNumber(String account) {
        return bankAccounts.stream().filter(a -> a.getAccountNumber().equals(account)).findFirst().orElse(null);
    }

    public BankAccount getAccountByAccountNumberAndUser(String account, String user) {
        return bankAccounts.stream().filter(a -> a.getAccountNumber().equals(account)).findFirst().filter(a -> a.getUser().getName().equals(user)).orElse(null);
    }

    public void printAccountByUser(String user) {
        for(BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getUser().getName().equals(user)) {
                System.out.println(bankAccount + "\n");
            }
        }

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

    public synchronized void newTransaction(BankAccount fromAccount, String toAccountNr, double amount) {
        if(fromAccount.isLocked()) {
            return;
        }
        BankAccount toAccount = getAccountByAccountNumber(toAccountNr);
        toAccount.addMoney(amount);
        fromAccount.withdrawMoney(amount);
        Transaction transaction = new Transaction(fromAccount.getAccountNumber(), toAccount.getAccountNumber(), amount);
        fromAccount.addToTransactionHistory(transaction);
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
