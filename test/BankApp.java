import java.util.*;

class BankApp {
    Map<String, Customer> customerList = new HashMap<>();
    Customer newCustomer;
    private int balance;
    private String userId;
    private int accNo;
    Scanner sc = new Scanner(System.in);

    BankApp(String name, int phoneNumber) {
        newCustomer = new Customer(name, phoneNumber);
    }

    private void askDetails() {
        System.out.println("enter the balance");
        balance = sc.nextInt();
    }

    public void createAccount() {
        try {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            int choice = sc.nextInt();
            System.out.println("enter the userId");
            userId = System.console().readLine();
            askDetails();
            if (choice == 1) {
                System.out.println("enter the tenure");
                int tenure = sc.nextInt();
                try {
                    newCustomer.createFixedDepositAccount(balance, tenure, userId);
                } catch (TenureException tenureException) {
                    System.out.println("invalid tenure or balance");
                    createAccount();
                }

            } else if (choice == 2) {
                // newCustomer.createSavingsAccount();
            } else {
                System.out.println("you have given wrong input please please retry");
                createAccount();
                // newCustomer.createCurrentAccount();
            }
        } catch (InputMismatchException e) {
            System.out.println("please try again");
            sc.next();
            createAccount();
        }

    }

    private void askUserIdAndAccNo() {
        System.out.println("enter the userId");
        userId = System.console().readLine();
        System.out.println("enter the accountNo");
        accNo = sc.nextInt();
    }

    public void withdraw() {
        int choice = 0;
        try {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            choice = sc.nextInt();
            if (choice == 1) {
                askUserIdAndAccNo();
                newCustomer.withdrawFixedDepositAccount(accNo, userId);
            } else if (choice == 2) {
                askUserIdAndAccNo();

            } else if (choice == 3) {
                askUserIdAndAccNo();
            } else {
                System.out.println("you have given wrong input please please retry");
                withdraw();
            }
        } catch (InputMismatchException inputMismatch) {
            System.out.println("please try again");
            sc.next();
            withdraw();
        }

    }

    public static void main(String[] args) {
        BankApp newBankApp = new BankApp("gjg", 213123123);
        newBankApp.createAccount();
        // newBankApp.withdraw();
    }

}