import java.util.*;

public class SavingsAccount extends BankAccount {
    FixedDeposit fd = null;
    Scanner in;
    private double balance;
    private Date dateOfOpening;
    private String password;

    // innner class FixedDeposit
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

    SavingsAccount(double bal, String acc, String password) {
        System.out.println("enter your name");
        customerName = System.console().readLine();
        System.out.println("want to  have FD or RD press 1 for FD and 2 for RD");
        in = new Scanner(System.in);
        this.password = password;
        choice = in.nextInt();
        balance = 0;
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

    // overriding deposit function to deposit amount
    // asking whether want to deposit fd or rd
    void deposit(double bal) {
        if (fd == null) {
            System.out.println("choose 1 to deposit fd or  2  deposit in Rd");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("enter the tenure");
                int tenu = in.nextInt();
                fd = new FixedDeposit();
                fd.create(bal, tenu);
            } else {
                balance += bal;
            }
        } else {
            balance += bal;
        }

        if (dateOfOpening == null) {
            dateOfOpening = new Date();
        }
    }

    // showing all the details of account if fd is present then asking to show
    // details of fd
    void showAccDetails() {
        if (fd != null) {
            System.out.println("choose 1 to see details of fd or  2 see details of rd");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.println("fdBalance:" + " " + fd.fdBalance);
                System.out.println("tenure:" + " " + fd.tenure);
                System.out.println("dateOfCreation" + fd.dateOfCreation);
                System.out.println("accNo" + accNo);

            } else {
                System.out.println("RdBalance:" + " " + balance);
                System.out.println("date" + " " + dateOfOpening);
            }
        } else {
            System.out.println("acc no" + " " + accNo);
            System.out.println("balance" + " " + balance);
            System.out.println("date" + " " + dateOfOpening);

        }

    }

    // utility function to call create function in class FixedDeposit
    // this will create fd
    void createFd(double bal, int tenure) {
        System.out.println("swqswqsqwss");
        fd = new FixedDeposit();
        fd.create(bal, tenure);
    }

    // function to withdraw amount from the account asking whether you want to break
    // fd
    void withdraw(String password, Double balance) {
        if (fd != null) {
            System.out.println("do you want break your fd or want to withdraw" + balance + "from RD");
            choice = in.nextInt();
            if (this.password.equals(password)) {
                if (choice == 1) {
                    System.out.println("your withDrawn amount" + fd.fdBalance);
                    fd = null;
                } else {
                    this.balance = this.balance - balance;
                }
            } else {
                System.out.println("pass wrong");
            }
        }

    }

}
