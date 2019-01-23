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
    private static int randomNumber = rand.nextInt(453453534);
    private String userId;
    private int accNo;
    // private static int randomNumberforAccount=rand.nextInt(1111);
    List<BankAccount> listOfAccounts;
    Map<String, List<BankAccount>> accounts;

    Customer(String name, int phoneNumber) {
        randomNumber = randomNumber + 1;
        String StringRandomNumber = Integer.toString(randomNumber);
        this.name = name;
        this.phoneNumber = phoneNumber;
        accounts = new HashMap<String, List<BankAccount>>();
        userId = name + StringRandomNumber;
        System.out.println("your userID is" + " " + userId);
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    private List<BankAccount> getAccountList(String userId) {
        return accounts.get(userId);
    }

    private BankAccount getAccount(int accNo, String userId) {
        BankAccount account = null;
        List<BankAccount> listOfAccounts = getAccountList(userId);
        for (int i = 0; i < listOfAccounts.size(); i++) {
            if (accNo == listOfAccounts.get(i).getAccountNo()) {
                account = listOfAccounts.get(i);
            }

        }
        if (account == null) {
            System.out.println("account not matched");
        }

        return account;

    }
/*
    cheking whether prevous accounts are present or nt based on that generating random accunt no
*/
    public void commonFunction(String userId) {
        if (getAccountList(userId) != null) {
            listOfAccounts = getAccountList(userId);
            accNo = 1 + listOfAccounts.get(listOfAccounts.size() - 1).getAccountNo();

        } else {
            listOfAccounts = new ArrayList<BankAccount>();
            accNo = rand.nextInt(111134);
        }
    }
/*
  creatng fixed deposit account
*/
    public void createFixedDepositAccount(int balance, int tenure, String userId) throws TenureException {
        commonFunction(userId);
        try {
            FixedDepositAccount newFixedDepositAccount = new FixedDepositAccount(balance, tenure, accNo);
            newFixedDepositAccount.intrestCalculation();
            listOfAccounts.add(newFixedDepositAccount);
            accounts.put(userId, listOfAccounts);
            System.out.println("your accNo is" + accNo);

        } catch (TenureException tenureException) {
            throw new TenureException();
        }
    }

    /*
    withdraw from fixed deposit 
*/
    public void withdrawFixedDepositAccount(int accNo, String userId) {
        BankAccount bankAccount = getAccount(accNo, userId);
        if (bankAccount.getAccountType() == "fixedDeposit") {
            bankAccount.withdraw();
        } else {
            System.out.println("wrong account type");
        }

    }

    public void createSavingsAccount(int balance, String userId) {
        commonFunction(userId);
        SavingsAccount newSavingsAccount = new SavingsAccount(balance, accNo, "savingsAccount");
        listOfAccounts.add(newSavingsAccount);
        accounts.put(userId, listOfAccounts);
        newSavingsAccount.startMinimumTransaction();
        System.out.println("your accNo is" + accNo);

    }

    public void withdrawSavingsAccount(String userId, int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo, userId);
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

    public void depositSavingsAccount(String userId, int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo, userId);
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

    public void createCurrentAccount(String userId, double balance) {
        commonFunction(userId);
        BankAccount currentAccount = new BankAccount(accNo, "currentAccount");
        listOfAccounts.add(currentAccount);
        accounts.put(userId, listOfAccounts);
        System.out.println("your accNo is" + accNo);

    }

    public void withdrawCurrentAccount(String userId, int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo, userId);
        if (bankAccount.getAccountType() == "currentAccount") {
            bankAccount.withdraw(balance);
        } else {
            System.out.println("wrong account type");
        }
    }

    public void depositCurrentAccount(String userId, int accNo, double balance) {
        BankAccount bankAccount = getAccount(accNo, userId);
        if (bankAccount.getAccountType() == "currentAccount") {
            bankAccount.deposit(balance);
        } else {
            System.out.println("wrong account type");
        }
    }

}