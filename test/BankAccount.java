import java.util.*;
import java.time.*;

class BankAccount {
    private int balance;
    private String password;
    private int accNo;
    private LocalDate dateOfCreation;


    BankAccount(int balance, String password,int accNo) {
        this.balance = balance;
        this.password = password;
        this.accNo=accNo;
        dateOfCreation=new LocalDate.now();
    }

    private Boolean checkPassword(String password)
    {       if(password.equals(this.password))
                    {
                        return true;
                    }
             return false;

    }

    public void withdraw(int balance,String password){
        if(checkPassword(password))
            {   
                if(this.balance>balance)
                    {
                        this.balance=this.balance-balance;
                    }
                else
                    {
                        System.out.println("insufficent funds");
                    }
                
            }
        else
            {
                System.out.println("password not matching");
            }
    }

    public Integer  getBalance(String password) {
        if(checkPassword(password))
            {    
                Integer balance=new Integer(4);
                return this.balance;
            }
      return null;
            
    }
    public void setBalance()
        {
                
        }


    public int  getAccountNo()
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
