import java.util.*;

abstract public class BankAccount {
    String accNo;
    abstract void deposit(double bal);

    abstract void withdraw(String password, Double balance);

    abstract void showAccDetails();

}
