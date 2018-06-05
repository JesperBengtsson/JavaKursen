import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Bank bank = new Bank();
        User user1 = new User("Batman");
        User user2 = new User ("Superman");
        bank.addAccount(user1, "123");
        bank.addAccount(user1, "555");
        bank.addAccount(user2, "321");

        String command = "";

        while(!command.equals("EXIT")) {
            System.out.println("--------MENU--------\n"
                    + "[0] To see ALL accounts\n[1] Choose user\n"
                    + "--------------------");
            command = br.readLine();

            if(command.equals("0")) {
                bank.printAllAccounts();
            }
            else if(command.equals("1")) {
                BankAccount bankAccount = null;
                while(bankAccount == null) {
                    System.out.println("Enter owner's name");
                    System.out.println("[MENU] Back to menu");
                    String chooseUser = br.readLine();
                    bank.printAccountByUser(chooseUser);
                    if(chooseUser.equals("MENU")){
                        break;
                    }
                    System.out.println("Enter account number");
                    String chooseAccount = br.readLine();
                    bankAccount = bank.getAccountByAccountNumberAndUser(chooseAccount, chooseUser);
                    if(bankAccount == null) {
                        System.out.println("Owner or account number does not match, check your information and try again.");
                    }
                }
                if(bankAccount == null) {
                    continue;
                }
                while (!command.equals("MENU")) {
                    System.out.println("You're working with\n" + bankAccount.toString() + "\n");
                    System.out.println("[0] To withdraw money\n[1] To deposit money\n[2] Transaction\n[3] Toggle account access\n[MENU] Back to menu");
                    command = br.readLine();
                    if(command.equals("0")) {
                        if(bankAccount.isLocked()) {
                            System.out.println("Access denied, account has been locked for withdrawal.");
                            continue;
                        }
                        else
                            System.out.println("Enter amount");
                            double amount = readAndParse();
                            if(bankAccount.withdrawMoney(amount)) {
                                bank.newTransaction(bankAccount, bankAccount.getAccountNumber(), amount);
                                System.out.println("You withdrew " + amount + "kr from account: " + bankAccount.getAccountNumber());
                                System.out.println("New balance " + bankAccount.getBalance() + "kr\n");
                            } else
                                System.out.println("You were denied your withdrawal, check your balance and try again.\n");
                    }
                    else if(command.equals("1")) {
                        System.out.println("Enter amount");
                        double amount = readAndParse();
                            if (bankAccount.addMoney(amount)) {
                                bank.newTransaction(bankAccount, bankAccount.getAccountNumber(), amount);
                                System.out.println("You deposited " + amount + "kr to account: " + bankAccount.getAccountNumber());
                                System.out.println("New balance " + bankAccount.getBalance() + "kr\n");
                            } else System.out.println("Deposite did not go through\n");
                    }
                    else if(command.equals("2")) {
                        while (!command.equals("BACK")) {
                            System.out.println("[0] For new transaction\n[1] To see transaction history\n[BACK] To back");
                            command = br.readLine();
                            if (command.equals("0")) {
                                System.out.println("Enter which account to make an transaction to.");
                                String toAccountNr = br.readLine();
                                if (bankAccount.getAccountNumber().equals(toAccountNr)) {
                                    System.out.println("You can't transfer money to your own account");
                                    continue;
                                }
                                System.out.println("Enter amount.");
                                double amount = readAndParse();
                                if (bankAccount.withdrawMoney(amount)) {
                                    try {
                                        bank.newTransaction(bankAccount, toAccountNr, amount);
                                    } catch (NullPointerException e) {
                                        System.out.println("Invalid account");
                                    }
                                } else
                                    System.out.println("Transaction did not go through, check your balance and try again.\n");
                            }
                            else if (command.equals("1")) {
                                bankAccount.listTransactions();
                                if(bankAccount.getTransactions().isEmpty()) {
                                    System.out.println("No previous transactions");
                                }
                            }
                        }
                    }
                    else if(command.equals("3")) {
                        bank.accountAccess(bankAccount);
                    }
                }
            }
        }
    }

    private static double readAndParse(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            double tmpDb = Double.parseDouble(br.readLine());
            return tmpDb;
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
    }
}