class FixedDepositAccount extends BankAccount {
    private int tenure;
    int penalty;
    int intrestRate;
    FixedDepositAccount(int balance, String password, int tenure,int accNo) {
        super(balance,password,accNo);
        this.tenure = tenure;
    }

    public void withdraw(int balance,String password) 
    {
        if(getBalance(password)!=null)
        {
            if (tenure > getDiffrence()) 
            {
                penalty = setPenalty(getDiffrence());
                int newPenalty = ((100 - penalty) * balance) / 100;
                System.out.println("your  penalty is"+newPenalty);
            }
               
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
            new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    int diff=getDiffrence();
                }
            },0,60000*60*24);
                
                        
        }

    

}