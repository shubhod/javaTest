import java.util.*;
import java.time.*;

class BankAccount {
    protected int balance;
    protected String password;
    protected String accNo;
    protected LocalDate dateOfCreation;
    protected LocalDate DateOfLastTransaction;

    BankAccount(int balance, String password) {
        this.balance = balance;
        this.password = password;
    }
    Boolean checkPassword(String password)
    {       if(password.equals(this.password))
                    {
                        return true;
                    }
             return false;

    }

    public void withdraw(int balance,String password){
        if(checkPassword(password))
            {
                this.balance=this.balance-balance;
            }
        else
            {
                System.out.println("password not matching");
            }
    }

    public void getBalance() {


    }
    public String  getAccountNo()
        {
                return accNo;
        }


    final public void deposit(){
        this.balance=this.balance-balance;
    }

    public void GetDateOfLastOfTransaction() {

    }

    public int getDiffrence() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfCreation = this.dateOfCreation;
        Period period = Period.between(dateOfCreation, today);
        return period.getMonths();
    }


}
