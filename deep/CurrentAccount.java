import java.util.*;
// class current account to create current account 

public class CurrentAccount extends BankAccount {

    private double balance;
    private Date dateOfOpening;
    String password;

    CurrentAccount(double bal, String acc) {
        accNo = acc;
        balance = bal;
        dateOfOpening = new Date();
        System.out.println("enter your name");
        customerName = System.console().readLine();
    }

    // overriding showAccDetails
    // shows account details
    void showAccDetails() {
        System.out.println("Balance:" + balance);
        System.out.println("Balance:" + accNo);
        System.out.println("dateOfCreation" + dateOfOpening);
    }

    void withdraw(String pass, Double balance) {
        if (pass.equals(pass)) {
            this.balance = this.balance - balance;
        } else {
            System.out.println("password not found" + " " + password);
        }

    }

    // overriding deposit function to deposit amount
    void deposit(double bal) {
        balance = balance + bal;
    }
}