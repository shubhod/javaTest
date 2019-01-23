package test2;


import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


public class SavingsAccountTest {

    private int noOfTransactions;

    @Test
    public void withdraw() {
        double balance=1;
        SavingsAccount savingsAccount=new SavingsAccount(300,234232,"savingsAccount");
        for(int i=0; i<=30;i++)
            {
                savingsAccount.withdraw(balance);
                System.out.println(savingsAccount.getNoOfTransactions());
                System.out.println(savingsAccount.getMinTransactions());
                assertTrue(savingsAccount.getMinTransactions()>savingsAccount.getNoOfTransactions());
            }


    }

    @Test
    public void deposit() {
        double balance=1;
        SavingsAccount savingsAccount=new SavingsAccount(300,234232,"savingsAccount");
        for(int i=0; i<=30;i++)
        {
            savingsAccount.deposit(balance);
            System.out.println(savingsAccount.getNoOfTransactions());
            System.out.println(savingsAccount.getMinTransactions());
            assertTrue(savingsAccount.getMinTransactions()>savingsAccount.getNoOfTransactions());
        }

    }

    @Test
    public void startMinimumTransaction() {

     final    SavingsAccount savingsAccount=new SavingsAccount(300,234232,"savingsAccount");
        savingsAccount.startMinimumTransaction();
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getNoOfTransactions());
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Sleeping...");
                    Thread.sleep(101100);

                } catch (InterruptedException e) {
                    System.out.println("I was interrupted!");
                    e.printStackTrace();
                }
                finally {
                    System.out.println("hello");
                }
            }
        };
        t.start();
        assertTrue(new Integer(savingsAccount.getNoOfTransactions())==0);
        System.out.println(savingsAccount.getNoOfTransactions());
    }
}
