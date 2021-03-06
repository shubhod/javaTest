import java.util.*;

// parent abstract class for currentAccount and SavingsAccount    

abstract public class BankAccount {
    String accNo;
    int choice;
    String depositType;
    String customerName;

    abstract void deposit(double bal);

    abstract void withdraw(String password, Double balance);

    abstract void showAccDetails();

}
