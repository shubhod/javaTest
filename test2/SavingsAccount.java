import java.util.*;
import java.time.LocalDate;

class SavingsAccount extends BankAccount {
    private int intrestRate = 3;
    final private int minTransactions = 30;
    private int noOfTransactions;

    SavingsAccount(double balance, int accNo, String accountType) {
        super(accNo, accountType);
        setBalance(balance);
    }

    void calculateIntrest() {

    }

    public void withdraw(double balance) {
        if (minTransactions > noOfTransactions) {
            super.withdraw(balance);
        } else {
            System.out.println("you have crossed your transactional limit");
            System.out.println("nOfTransactions" + " " + noOfTransactions);
            System.out.println("nOfTransactions" + " " + minTransactions);
        }
    }

    public void deposit(double balance) {
        if (minTransactions > noOfTransactions) {
            super.deposit(balance);
        } else {
            System.out.println("you have crossed your transactional limit");
            System.out.println("nOfTransactions" + " " + noOfTransactions);
            System.out.println("nOfTransactions" + " " + minTransactions);
        }

    }

    private TimerTask setMinimumTransactions() {

        return new TimerTask() {
            public void run() {
                LocalDate date = LocalDate.now();
                String[] splitDate = date.toString().split("-");
                if (splitDate[2].equals("01")) {
                    noOfTransactions = 0;
                }

            }
        };

    }

    public void startMinimumTransaction() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(setMinimumTransactions(), 0, 60000 * 60 * 24);
    }

}
