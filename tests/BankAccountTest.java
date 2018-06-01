import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private Bank bank;
    private User user;
    private BankAccount account;

    @Before
    public void setUp() {
        bank = new Bank();
        user = new User("Batman");

        bank.addAccount(user, "123");
        account = bank.getAccountByAccountNumber("123");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addMoney() {
        account.addMoney(100);
        assertEquals(100.0, account.getBalance(), 0.0);
        assertNotEquals("Can't add negative numbers", 0.0, account.addMoney(-500));
    }

    @Test
    public void withdrawMoney() {
        assertEquals(0, account.getBalance(), 0.0 );
        assertNotEquals("Balance is below zero after withdrawal", account.withdrawMoney(100.0));

        account.addMoney(300);
        assertTrue("withdrawal failed", account.withdrawMoney(100.0));
        assertEquals("Incorrect balance, successful withdrawal", 200.0, account.getBalance(), 0.0);
        assertNotEquals("Balance can't be below zero", 0.0,account.withdrawMoney(-500.0));
    }
}