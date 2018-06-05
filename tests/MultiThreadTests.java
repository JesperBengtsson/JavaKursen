import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class MultiThreadTests {

    private Bank bank;
    private User user;

    private BankAccount account1;
    private BankAccount account2;

    final int THREADS = 5;
    private ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private CountDownLatch latch = new CountDownLatch(THREADS);

    @Before
    public void setUp(){
        bank = new Bank();
        user = new User("Batman");

        bank.addAccount(user, "555");
        account1 = bank.getAccountByAccountNumber("555");

        bank.addAccount(user, "666");
        account2 = bank.getAccountByAccountNumber("666");
    }

    @Test
    public void depositeMultiThread() {
        for(int i = 0; i < THREADS; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 100; i++) {
                        account1.addMoney(100);
                    }
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();
        try {
            latch.await();
            assertEquals(THREADS*10000, account1.getBalance(), 0.0);

        } catch(InterruptedException e) {

        }
    }

    @Test
    public void withdrawMultiThread() {
        account1.setBalance(50000);
        for(int i =0; i < THREADS; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 100; i++) {
                        account1.withdrawMoney(100);
                    }
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();
        try {
            latch.await();
            assertEquals(0, account1.getBalance(), 0.0);
        } catch(InterruptedException e) {

        }
    }

    @Test
    public void TestTransactionThread() {

        account1.setBalance(10000);
        account2.setBalance(10000);

        for(int i = 0; i < THREADS; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 100; i++) {
                        bank.newTransaction(account1, "666", 10);
                    }
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();

        try {
            latch.await();
            assertEquals(5000, account1.getBalance(), 0.0);
            assertEquals(15000, account2.getBalance(), 0.0);
        } catch(InterruptedException e) {

        }
    }
}