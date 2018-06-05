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

    @Test
    public void listTransactions() {
        bank.addAccount(user, "777");
        BankAccount newAccount = bank.getAccountByAccountNumber("777");
        account.setBalance(2000);
        account.setBalance(2000);
        bank.newTransaction(account, "777", 1000);
        bank.newTransaction(newAccount, "123", 1000);
        assertEquals("Transaction was not added correctly", 2, account.getTransactions().size());
        assertNotEquals("Transaction was not added correctly", 1, newAccount.getTransactions().size());
    }
}