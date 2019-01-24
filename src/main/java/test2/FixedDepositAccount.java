package test2;

import test2.BankAccount;

import java.util.*;
import java.time.LocalDate;

class FixedDepositAccount extends BankAccount {
    private int tenure;
    private int penalty;
    final private int intrestRate=8;

    FixedDepositAccount(int balance, int tenure, int accNo) throws TenureException {
        super(accNo, "fixedDeposit");
        setBalance(balance);
        if (tenure >= 2) {
            this.tenure = tenure;
        } else {
            throw new TenureException();
        }

    }
    /*
    function checking tenure and withdraw
*/

    public void withdraw() {

        if (tenure > getDiffrence()) {
            penalty = setPenalty(getDiffrence());
            double newPenalty = ((100 - penalty) * getBalance()) / 100;
            System.out.println("your  penalty is" + newPenalty);
            double finalAmount = getBalance() - newPenalty;
            System.out.println("you will get" + " " + finalAmount);
        } else {
            System.out.println("withdrawn");
        }
    }

    private int setPenalty(int diffrence) {
        if (diffrence > 4) {
            return 10;
        } else {
            return 4;
        }

    }
/*
   scheduling task after every month to add intrest
*/
    public void intrestCalculation() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                double balance = getBalance();
                double intrest = ((100 - intrestRate) * balance) / 100;
                balance = intrest + balance;
                setBalance(balance);
            };
        };
        timer.scheduleAtFixedRate(timerTask,6000,60*60*24*30);

    }

}