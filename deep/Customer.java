
import java.util.*;

// class Customer to create customer and account
public class Customer {
    String customerName;
    int phNo;
    private HashMap<Integer, ArrayList<SavingsAccount>> savingsAccountList;
    private HashMap<Integer, ArrayList<CurrentAccount>> currentAccountList;
    Scanner in;

    // private HashMap<Integer, ArrayList<SavingsAccount>> savingsAccountList;
    Customer() {
        savingsAccountList = new HashMap<>();
        currentAccountList = new HashMap<>();
        in = new Scanner(System.in);
    }

    // returning list of savings account related to that customer
    ArrayList<SavingsAccount> returnArrayListofSavingsAccount(int ph) {
        ArrayList<SavingsAccount> s = null;
        if (savingsAccountList.containsKey(ph)) {
            s = savingsAccountList.get(ph);
        }
        return s;

    }

    // returning a perticular savings account object based on parameter provided
    SavingsAccount getSavingsAccount(String acc, int ph) {
        ArrayList<SavingsAccount> s = returnArrayListofSavingsAccount(ph);
        SavingsAccount svobj = null;
        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).accNo.equals(acc)) {
                    svobj = s.get(i);
                }

            }
        } else {
            System.out.println("savings list not found");
        }

        return svobj;

    }

    // returning list of current account related to that customer
    ArrayList<CurrentAccount> returnArrayListofcurrentAccount(int ph) {
        ArrayList<CurrentAccount> s = null;
        if (currentAccountList.containsKey(ph)) {
            s = currentAccountList.get(ph);
        }
        return s;

    }

    // returning a perticular current account object based on parameter provided
    CurrentAccount getcurrentAccount(String acc, int ph) {
        ArrayList<CurrentAccount> s = returnArrayListofcurrentAccount(ph);
        CurrentAccount svobj = null;
        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                System.out.println(s.get(i).accNo);
                if (acc.equals(s.get(i).accNo)) {
                    svobj = s.get(i);
                } else {
                    System.out.println("acc not matching");
                }

            }
        } else {
            System.out.println("acc not found");
        }

        return svobj;
    }

    // shows detail for savings account called by function showAccountDetails
    void showDetailsSavingsAccountList(int ph) {
        if (returnArrayListofSavingsAccount(ph) != null) {
            ArrayList<SavingsAccount> s = returnArrayListofSavingsAccount(ph);
            System.out.println("saving account details..");
            for (int i = 0; i < s.size(); i++) {
                s.get(i).showAccDetails();
            }
        } else {
            System.out.println("no savingsAccount  found");
        }
    }

    // shows detail for current account called by function showAccountDetails
    void showDetailsCurrentAccountList(int ph) {
        ArrayList<CurrentAccount> l1;
        if (returnArrayListofcurrentAccount(ph) != null) {
            System.out.println("current account details..");
            l1 = returnArrayListofcurrentAccount(ph);
            for (int i = 0; i < l1.size(); i++) {
                l1.get(i).showAccDetails();
            }
        } else {
            System.out.println("no currentAccount  found");
        }
    }

    // utility function to createAccount savings or current
    void createAcount() {
        in = new Scanner(System.in);
        System.out.println("enter your name");
        customerName = System.console().readLine();
        System.out.println("enter the phone no");
        phNo = in.nextInt();
        System.out.println("press1  for savings account or 2 for current account");
        int choice = in.nextInt();
        String accNo = "accNo" + new Date().toString().replaceAll("\\s+", "");
        System.out.println("enter some initial balanace");
        int balance = in.nextInt();
        System.out.println("enter the password");
        String password = System.console().readLine();
        ArrayList<SavingsAccount> savingList;
        ArrayList<CurrentAccount> currentList;
        Integer i = new Integer(phNo);
        if (choice == 1) {
            if (returnArrayListofSavingsAccount(phNo) == null) {
                savingList = new ArrayList<>();
            } else {
                savingList = savingsAccountList.get(i);
            }
            savingList.add(createSavingsAccount(balance, accNo, password));
            savingsAccountList.put(i, savingList);
        } else {
            if (returnArrayListofcurrentAccount(phNo) == null) {

                currentList = new ArrayList<>();
            } else {
                currentList = currentAccountList.get(i);

            }
            currentList.add(createCurrentAccount(balance, accNo));
            currentAccountList.put(i, currentList);

        }

    }

    // this function is creating object for savings account and is called by
    // createAccount function
    SavingsAccount createSavingsAccount(double bal, String accNo, String password) {
        SavingsAccount sv = new SavingsAccount(bal, accNo, password);
        System.out.println("your account no is" + " " + accNo);
        return sv;
    }

    // this function is creating object for current account and is called by
    // createAccount function
    CurrentAccount createCurrentAccount(double bal, String accNo) {
        CurrentAccount c = new CurrentAccount(bal, accNo);
        System.out.println("your account no is" + " " + accNo);
        return c;
    }

    // utility function to deposit amount whether in savings or current
    void deposit() {
        System.out.println("enter the phone no and account no you want to deposit");
        int ph = in.nextInt();
        String acc = System.console().readLine();
        System.out.println("press 1 for savings account or 2 for current account");
        int choice = in.nextInt();
        System.out.println("enter the amount");
        double amount = in.nextDouble();
        if (choice == 1) {
            BankAccount sv = getSavingsAccount(acc, ph);
            if (sv != null) {
                sv.deposit(amount);
            } else {
                System.out.println("sv is null");
            }

        } else {
            BankAccount cv = getcurrentAccount(acc, ph);
            if (cv != null) {
                cv.deposit(amount);
            } else {
                System.out.println("sv is null");

            }

        }

    }

    // showing details of all saving accounts and current accounts of perticular
    // Customer
    void showAccountDetails() {
        System.out.println("enter the phone no");
        int ph = in.nextInt();
        showDetailsSavingsAccountList(ph); // function defined at beginning gives list of savings account
        showDetailsCurrentAccountList(ph); // function defined at beginning gives list of current account
    }

    // function to withdraw amount from savings or current account
    void withdraw() {
        System.out.println("enter the phone no");
        int ph = in.nextInt();
        System.out.println("press 1  for savings account or 2 for current account");
        int choice = in.nextInt();
        System.out.println(" enter the account no you want to withdraw from");
        String acc = System.console().readLine();
        System.out.println("enter the amount ");
        double amount = in.nextDouble();
        System.out.println("enter the password");
        String pass = System.console().readLine();
        if (choice == 1) {
            SavingsAccount sv = getSavingsAccount(acc, ph);
            sv.withdraw(pass, amount);
        } else {
            CurrentAccount cv = getcurrentAccount(acc, ph);
            cv.withdraw(pass, amount);
        }

    }

}
