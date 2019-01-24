package test2;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BankAccountTest{
    private BankAccount bankAccount;
    private double balance;

    public BankAccountTest(double balance)
    {
        this.balance=balance;
    }
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[]{400,-400});
    }


    @org.junit.Test
    public void deposit() {

                BankAccount bankAccount=new BankAccount(3123323,"fixedDeposit");
                Double oldBalance=bankAccount.getBalance();
                Double deposit=new Double(balance);
                bankAccount.deposit(deposit);
                Double newBalance=bankAccount.getBalance();
                assertEquals(new Double(deposit+oldBalance),newBalance);

    }
    @Parameterized.Parameters
    public static Collection input2()
    {
        return Arrays.asList(new Object[]{400,800});
    }

    @org.junit.Test
    public void withdraw() {
        BankAccount bankAccount=new BankAccount(3123323,"fixedDeposit");
        bankAccount.setBalance(400);
        Double oldBalance=bankAccount.getBalance();
        Double withdrawBalance=new Double(balance);
        bankAccount.withdraw(withdrawBalance);
        Double newBalance=bankAccount.getBalance();
        assertEquals(new Double(oldBalance-withdrawBalance),newBalance);

    }

    @org.junit.Test
    public void getBalance() {
        BankAccount bankAccount=new BankAccount(3123323,"fixedDeposit");
        bankAccount.setBalance(400);
        assertEquals(new Double(400),bankAccount.getBalance());

    }
    @Before
    @Parameterized.Parameters
    public static Collection input3()
    {
        return Arrays.asList(new Object[]{-400,-400});
    }

    @org.junit.Test
    public void setBalance(){
        BankAccount bankAccount=new BankAccount(3123323,"fixedDeposit");
        Double oldBalance=bankAccount.getBalance();
        System.out.println(this.balance);
        bankAccount.setBalance(this.balance);
        Double newBalance=bankAccount.getBalance();
        assertEquals(new Double(balance),newBalance);
    }



    @org.junit.Test
    public void getAccountNo() {
        BankAccount bankAccount=new BankAccount(3123323,"fixedDeposit");
        assertEquals(new Integer(3123323),new Integer(bankAccount.getAccountNo()));

    }

//    @org.junit.Test
//    public void getDiffrence() {
//    }
//
//    @org.junit.Test
//    public void getAccountType() {
//    }
}
