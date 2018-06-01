import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    private Bank bank;
    private User user;
    private BankAccount account1;
    private BankAccount account2;

    @Before
    public void setUp(){
        bank = new Bank();
        user = new User("Batman");
        bank.addAccount(user, "555");
        account1 = bank.getAccountByAccountNumber("555");
        account1.setBalance(5000);

        bank.addAccount(user, "666");
        account2 = bank.getAccountByAccountNumber("666");
        account2.setBalance(1000000);
    }

    @After
    public void tearDown(){
    }

    @Test
    public void addAccount() {
    }
}