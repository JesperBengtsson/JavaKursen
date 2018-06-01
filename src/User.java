import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<BankAccount> accountId;

    public User(String name) {
        this.name = name;
        accountId = new ArrayList<>();
    }

    public void addAccountId(BankAccount account) {
        accountId.add(account);
    }

    //Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<BankAccount> getAccountId() {
        return accountId;
    }
}
