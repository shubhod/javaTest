package test2;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer=new Customer("rererer",31231232);

    @Test
    public void createFixedDepositAccount()
    {
        try {
            customer.createFixedDepositAccount(3214,2);
            customer.createFixedDepositAccount(3214,4);
        } catch (TenureException e) {
            System.out.println("exception caught");
        }
        Integer i=2;
        assertEquals(new Integer(customer.accounts.size()),i);
    }
    @Test
    public void withdrawFixedDepositAccount() {

        try {
            customer.createFixedDepositAccount(3214,2);
            customer.createFixedDepositAccount(3214,4);
        } catch (TenureException e) {
            System.out.println("exception caught");
        }
        Integer i=2;
        assertEquals(new Integer(customer.accounts.size()),i);

    }

    // Testing for false condition
    @Test
    public void withdrawFixedDepositAccount2() {
        customer.createSavingsAccount(32142);
        customer.withdrawCurrentAccount(customer.accNo,4324);
        //customer.withdrawFixedDepositAccount(customer.accNo);

    }

    @Test
    public void createSavingsAccount() {
        customer.createSavingsAccount(32142);
        customer.createSavingsAccount(32142);
        Integer i=2;
        assertEquals(new Integer(customer.accounts.size()),i);

    }

    @Test
    public void withdrawSavingsAccount() {
        customer.createSavingsAccount(32142);
        Double oldBalance=customer.getBalance(customer.accNo);
        customer.withdrawSavingsAccount(customer.accNo,334);
        Double newBalance=customer.getBalance(customer.accNo);
        assertNotEquals(oldBalance,newBalance);

    }

    @Test
    public void depositSavingsAccount() {
        customer.createSavingsAccount(32142);
        Double oldBalance=customer.getBalance(customer.accNo);
        customer.depositSavingsAccount(customer.accNo,334);
        Double newBalance=customer.getBalance(customer.accNo);
        assertNotEquals(oldBalance,newBalance);
    }


    @Test
    public void createCurrentAccount() {


    }

    @Test
    public void withdrawCurrentAccount() {

    }

    @Test
    public void depositCurrentAccount() {
    }
}