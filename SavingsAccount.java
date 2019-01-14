import java.util.*;

public class SavingsAccount extends BankAccount {
    String depositType;
    FixedDeposit fd = null;
    Scanner in;
    private double balance;
    private Date dateOfOpening;
    private String password;

    private class FixedDeposit {
        double fdBalance;
        int tenure;
        Date dateOfCreation;

        FixedDeposit() {
            fdBalance = 0;
        }

        void create(double bal, int tenu) {
            fdBalance = bal;
            tenure = tenu;
            dateOfCreation = new Date();
        }
    }

    // common function to deposit amount
    // private void depositCommon(double bal, String flag) {
    // in = new Scanner(System.in);
    // System.out.println("want to have FD or RD press 1 for FD and 2 for RD");
    // int choice = in.nextInt();
    // if (choice == 1) {
    // depositType = "FD";
    // System.out.println("enter the tenure you want");
    // fd.fdBalance += bal;
    // fd.tenure = in.nextInt();
    // fd.dateOfCreation = new Date();
    // depositType = "FD";

    // } else {
    // depositType = "RD";
    // balance += bal;
    // }
    // if (flag == "x") {
    // dateOfOpening = new Date();
    // System.out.println("first time creation");

    // }
    // }

    SavingsAccount(double bal, String acc, String password) 
    {
        System.out.println("want to  have FD or RD press 1 for FD and 2 for RD");
        in = new Scanner(System.in);
        this.password = password;
        int choice = in.nextInt();
        accNo = acc;
        if (choice == 1) {
            System.out.println("enter the tenure you want");
            int tenure = in.nextInt();
            createFd(bal, tenure);
        } else {
            balance = bal;
            dateOfOpening = new Date();
        }
    }

    void deposit(double bal) {
        balance += bal;
    }

    void showAccDetails() {
        if (fd != null) {
            System.out.println("choose 1 to see details of fd or  2 see details of rd or 3 for both");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("fdBalance:" + " " + fd.fdBalance);
                System.out.println("tenure:" + " " + fd.tenure);
                System.out.println("dateOfCreation" + fd.dateOfCreation);
                System.out.println("accNo" + accNo);

            } else {
                System.out.println("fdBalance:" + " " + fd.fdBalance);
            }
        } else {
            System.out.println("acc no" + " " + accNo);
            System.out.println("balance" + " " + balance);
            System.out.println("date" + " " + dateOfOpening);

        }

    }

    void createFd(double bal, int tenure) {
        System.out.println("swqswqsqwss");
        fd = new FixedDeposit();
        fd.create(bal, tenure);
    }

    void withdraw(String password, Double balance) {
        if (this.password.equals(password)) {
            this.balance = -balance;
        } else {
            System.out.println("pass wrong");
        }

    }

}
