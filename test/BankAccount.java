import java.util.*;
import java.time.*;

class BankAccount {
    private double balance;
    private int accNo;
    private LocalDate dateOfCreation;
    private String accountType;

    BankAccount(int accNo, String accountType) {
        this.accNo = accNo;
        dateOfCreation = LocalDate.now();
        setAccountType(accountType);
    }

    public void deposit(double balance) {

        if (balance > 0) {
            this.balance = this.balance + balance;
        } else {
            System.out.println("invalid balance");
        }
    }

    public void withdraw(double balance) {
        if (this.balance > balance) {
            this.balance = this.balance - balance;
        } else {
            System.out.println("insufficent funds");
        }

    }

    public void withdraw() {

    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("balance less than 0 cannot be assigned");
        }

    }

    public int getAccountNo() {
        return accNo;
    }

    public int getDiffrence() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfCreation = this.dateOfCreation;
        Period period = Period.between(dateOfCreation, today);
        return period.getMonths();

    }

    public String getAccountType() {
        return accountType;
    }

    private void setAccountType(String accountType) {
        if (accountType.equals("fixedDeposit") || accountType.equals("currentAccount")
                || accountType.equals("savingsAccount")) {
            this.accountType = accountType;
        } else {
            System.out.println("wrong setup of accountType");
        }

    }
}
