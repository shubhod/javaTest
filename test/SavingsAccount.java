
class SavingsAccount extends BankAccount {
    final private int intrestRate = 3;
    private int monthlyIntrest;

    SavingsAccount(int balance, String password) {
        super(balance, password);
    }

    void calculateIntrest() {

    }

   public  void withdraw() {
          System.out.println("savings withdraw");

    }
}