import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {



    private String fromAccount;
    private String toAccount;
    private double amount;
    private LocalDateTime time;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Transaction(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public String getFromAccount() {
        return fromAccount;
    }

    @Override
    public String toString() {
        return "Transaction id: " + hashCode() + "\nFrom account: " + fromAccount
                + "\nTo account: " + toAccount + "\nAmount: " + amount + "kr" + "\nTime: " + formatter.format(time);
    }
}
