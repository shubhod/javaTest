package test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
public class FixedDepositAccountTest {

    @Test
    public void withdraw() {

        try
        {

            FixedDepositAccount fixedDepositAccount=new FixedDepositAccount(321,4,356654);

        }
        catch (Exception e)
        {

        }
//        oldBalance=fixedDepositAccount.getBalance();
//        fixedDepositAccount.withdraw();
//        newBalance=fixedDepositAccount.getBalance();
//        assertTrue(oldBalance==newBalance);

    }

    @Test
    public void intrestCalculation() {


    }
}
