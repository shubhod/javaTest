package test2;

import java.util.*;
/**
 * class holding al the accounts of the customer
 * 
 */
class Customer {
    private String name;
    private int phoneNumber;
    private static Random rand = new Random();
    private static int accountRandomNumber = rand.nextInt(453453534);
    int accNo;
    // private static int randomNumberforAccount=rand.nextInt(1111);

    // access modifiers kept default  for testing purpose
    List<BankAccount> listOfAccounts;
    Map<Integer,BankAccount> accounts=null;
    Customer(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        //accounts=new HashMap<Integer, BankAccount>();
    }

    /**
     * @return the userId
     */



    public BankAccount getAccount(int accNo) {
        BankAccount account = null;
        account=accounts.get(accNo);

        if (account == null) {
            System.out.println("account not matched");
        }

        return account;

    }
/*
    cheking whether prevous accounts are present or nt based on that generating random accunt no
*/
    private void commonFunction() {
        if (accounts != null) {
            accNo = 1 + accNo;

        } else {
            accNo = accountRandomNumber;
            accounts = new HashMap<Integer,BankAccount>();
        }
            System.out.println("accNo:"+" "+accNo);
    }
/*
  creatng fixed deposit account
*/
    public void createFixedDepositAccount(int balance, int tenure) throws TenureException {
        commonFunction();
        try {
            FixedDepositAccount newFixedDepositAccount = new FixedDepositAccount(balance, tenure, accNo);
            newFixedDepositAccount.intrestCalculation();
            accounts.put(accNo,newFixedDepositAccount);
            System.out.println("your accNo is" + accNo);

        } catch (TenureException tenureException) {
            throw new TenureException();
        }
    }

    /*
    withdraw from fixed deposit 
*/
    public void withdrawFixedDepositAccount(int accNo) {

        BankAccount bankAccount = getAccount(accNo);
        if(bankAccount!=null)
        {
            if (bankAccount.getAccountType() == "fixedDeposit") {
                bankAccount.withdraw();
            } else {
                System.out.println("wrong account type");
            }
        }
        else
        {
            System.out.println("account number does not exists");
        }


    }

    public void createSavingsAccount(int balance) {
        commonFunction();
        SavingsAccount newSavingsAccount = new SavingsAccount(balance, accNo, "savingsAccount");
        accounts.put(accNo, newSavingsAccount);
        newSavingsAccount.startMinimumTransaction();
        System.out.println("your accNo is" + accNo);

    }

    public void withdrawSavingsAccount(int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo);
        if (bankAccount != null) {
            if (bankAccount.getAccountType() == "savingsAccount") {
                bankAccount.withdraw(balance);
            } else {
                System.out.println("wrong account type");
            }
        } else {
            System.out.println("bank Account not found");
        }

    }

    public void depositSavingsAccount(int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo);
        if (bankAccount != null) {
            if (bankAccount.getAccountType() == "savingsAccount") {
                bankAccount.deposit(balance);
            } else {
                System.out.println("wrong account type");
            }
        } else {
            System.out.println("bank Account not found");
        }

    }

    public void createCurrentAccount(double balance) {
        commonFunction();
        BankAccount currentAccount = new BankAccount(accNo, "currentAccount");
        accounts.put(accNo,currentAccount);
        System.out.println("your accNo is" + accNo);

    }

    public void withdrawCurrentAccount(int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo);
        if (bankAccount.getAccountType() == "currentAccount") {
            bankAccount.withdraw(balance);
        } else {
            System.out.println("wrong account type");
        }
    }

    public void depositCurrentAccount(int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo);
        if (bankAccount.getAccountType() == "currentAccount") {
            bankAccount.deposit(balance);
        } else {
            System.out.println("wrong account type");
        }
    }
    public Double getBalance(int accNo)
    {   BankAccount bankAccount = getAccount(accNo);

        return bankAccount.getBalance();
    }

}