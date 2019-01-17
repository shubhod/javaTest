class FixedDepositAccount extends BankAccount {
    private int tenure;
    int penalty;
    int intrestRate;
    FixedDepositAccount(int balance, String password, int tenure,String accNo) {
        super(balance, password);
        this.tenure = tenure;
        this.accNo=accNo;
    }

   
    public void withdraw(int balance,String password) 
    {
        if(checkPassword(password))
        {
            if (tenure > getDiffrence()) {
                penalty = setPenalty(getDiffrence());
                int newPenalty = ((100 - penalty) * balance) / 100;
                System.out.println("your  penalty is"+newPenalty);
            }
            this.balance=this.balance-balance;
        }
        else
            {
                System.out.println("password not matching");
            }
    }

    private int setPenalty(int diffrence) {
        if (diffrence > 4) {
            return 10;
        } else {
            return 4;
        }

    }

    private void intrestCalculation()
        {

        }

}