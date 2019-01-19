import java.util.*;
class SavingsAccount extends BankAccount {
     private int intrestRate = 3;    
    
     SavingsAccount(int balance, String password,int accNo) {
        super(balance, password,accNo);
    }

   private  void calculateIntrest() {
    new Timer().scheduleAtFixedRate(new TimerTask(){
        public void run(){
           int diffrence=getDiffrence();
           int balance=getBalance(this.password);
           int intrest=((100-intrestRate)*balance)/100;
        }
    },0,60000*60*24*30);

    }
  

}