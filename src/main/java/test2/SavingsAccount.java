package test2;

import java.util.*;
import java.time.LocalDate;
    /*
   class account savings account
*/
class SavingsAccount extends BankAccount {
    private int intrestRate = 3;
    final private int minTransactions = 30;
    private int noOfTransactions;

    SavingsAccount(double balance, int accNo, String accountType) {
        super(accNo, accountType);
        this.noOfTransactions=0;
        setBalance(balance);
    }

    void calculateIntrest() {

    }

    /*
    withdrawing balance first checking wether not crossed th minimum transaction
*/
    public void withdraw(double balance) {
        if (minTransactions > noOfTransactions) {
            super.withdraw(balance);
            System.out.println("balance withdrawn");
            noOfTransactions=noOfTransactions+1;
        } else {
            System.out.println("you have crossed your transactional limit");
            System.out.println("nOfTransactions" + " " + noOfTransactions);
            System.out.println("nOfTransactions" + " " + minTransactions);
        }
    }

    /*
    depositing balance first checking wether not crossed th minimum transaction
*/
    public void deposit(double balance) {
        if (minTransactions > noOfTransactions) {
            super.deposit(balance);
            noOfTransactions=noOfTransactions+1;
            System.out.println("balance deposited");
        } else {
            System.out.println("you have crossed your transactional limit");
            System.out.println("nOfTransactions" + " " + noOfTransactions);
            System.out.println("nOfTransactions" + " " + minTransactions);
        }

    }
/*
    setting minimumTransaction after every month to 0
*/
    private TimerTask setMinimumTransactions() {
        return new TimerTask() {
            public void run() {
                LocalDate date = LocalDate.now();
                String[] splitDate = date.toString().split("-");
                if (splitDate[2].equals("23")) {
                    System.out.println("hey");
                    noOfTransactions = 0;
                }

            }
        };

    }
    /*
    scheduling the timer task
    */

    public void startMinimumTransaction() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(setMinimumTransactions(),110, 1111);
    }
    public int getMinTransactions()
    {
        return minTransactions;
    }
    public  int getNoOfTransactions(){
        return  noOfTransactions;
    }

}
