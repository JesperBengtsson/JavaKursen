import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void newUser() {
        assertNotNull(user);
        assertEquals("Name needs to be set", "Batman", user.getName());
        assertNotNull("Account ID needs to be init", user.getAccountId());
    }

    @Test
    public void getAccountByAccountNumber() {
        ArrayList<BankAccount> bankAccounts = bank.getBankAccounts();
        for(int i = 0; i < 1000; i++) {
            assertNotNull("Accounts wasn't added to list correctly", bankAccounts);
            assertEquals("Size is incorrect", 2, bankAccounts.size());
        }
        bank.addAccount(user, "777");
        for(int i = 0; i < 1000; i++) {
            BankAccount newAccount = bank.getAccountByAccountNumber("777");
            assertTrue("Account wasn't added correctly", bankAccounts.contains(newAccount));
        }
    }

    @Test
    public void getAccountByAccountNumberAndUser() {
        ArrayList<BankAccount> bankAccounts = bank.getBankAccounts();
        for(int i = 0; i < 1000; i++) {
            assertNotNull("Accounts wasn't added to list correctly", bankAccounts);
            assertEquals("Size is incorrect", 2, bankAccounts.size());
        }
        bank.addAccount(user, "777");
        for(int i = 0; i < 1000; i++) {
            BankAccount newAccount = bank.getAccountByAccountNumberAndUser("777", "Batman");
            assertTrue("Account wasn't added correctly", bankAccounts.contains(newAccount));
        }
    }

    @Test
    public void addAccount() {
        bank.addAccount(user, "777");
        BankAccount newAccount = bank.getAccountByAccountNumber("777");
        assertTrue("User account ID not added correctly", user.getAccountId().contains(newAccount));
        assertEquals("New account wasn't added correctly", 3, bank.getBankAccounts().size());
        bank.addAccount(user, "777");
        assertEquals("Can't add account with same ID", 3, bank.getBankAccounts().size());
    }

    @Test
    public void TestTransaction() {
        for(int i = 0; i < 1000; i++) {
            bank.newTransaction(account1, "666", 4000);
            assertEquals("Transaction failed", 1000, account1.getBalance(), 0.0);
        }
    }

    @Test
    public void TestTransactionBalanceCantBeBelowZero() {
        for(int i = 0; i < 1000; i++) {
            bank.newTransaction(account1, "666", 5001);
            assertEquals("Can't have negative balance", 5000, account1.getBalance(), 0.0);
        }
    }

    @Test
    public void TestTransactionWithLockedAccount() {
        bank.accountAccess(account1);
        for(int i = 0; i < 1000; i++) {
            bank.newTransaction(account1, "666", 1000);
            assertEquals("Account not locked correctly", 5000, account1.getBalance(), 0.0);
        }
    }

    @Test
    public void TestTransactionToOwnAccount() {
        for(int i = 0; i < 1000; i++) {
            bank.newTransaction(account1, "555", 1000);
            assertEquals("Can't transfer to own account", 5000, account1.getBalance(), 0.0);
        }
    }


}