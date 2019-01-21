import java.util.*;

class BankApp {
    Map<String, Customer> customerList = new HashMap<>();
    Customer newCustomer;
    private int balance;
    private String userId;
    private int accNo;
    Scanner sc = new Scanner(System.in);

    String register(String name, int phoneNumber) {
        newCustomer = new Customer(name, phoneNumber);
        return newCustomer.getUserId();
    }

    private void askDetails() {
        System.out.println("enter the balance");
        balance = sc.nextInt();
    }

    public void createAccount() {
        try {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            int choice = sc.nextInt();
            // System.out.println("enter the userId");

            // try {
            // userId = System.console().readLine();
            // if (userId.length() < 5) {
            // throw new Exception();
            // }
            // } catch (Exception e) {
            // System.out.println("invalid userId");
            // createAccount();
            // }

            askDetails();
            if (choice == 1) {
                System.out.println("enter the tenure");
                int tenure = sc.nextInt();
                try {
                    newCustomer.createFixedDepositAccount(balance, tenure, newCustomer.getUserId());
                } catch (TenureException tenureException) {
                    System.out.println("invalid tenure or balance");
                    createAccount();
                }

            } else if (choice == 2) {
                askDetails();
                newCustomer.createSavingsAccount(balance, newCustomer.getUserId());
            } else if (choice == 3) {
                askDetails();
                newCustomer.createCurrentAccount(newCustomer.getUserId(), balance);
            } else {
                System.out.println("you have given wrong input please please retry");
                createAccount();
            }
        } catch (InputMismatchException e) {
            System.out.println("please try again");
            sc.next();
            createAccount();
        }
        customerList.put(userId, newCustomer);

    }

    private void askUserIdAndAccNo() {
        try {
            System.out.println("enter the accountNo");
            accNo = sc.nextInt();
            if (userId.length() < 4) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("invalid userId");
            withdraw();
        }

    }

    public void withdraw() {
        int choice = 0;
        try {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            choice = sc.nextInt();
            if (choice == 1) {
                askUserIdAndAccNo();
                newCustomer.withdrawFixedDepositAccount(accNo, newCustomer.getUserId());
            } else if (choice == 2) {
                askUserIdAndAccNo();
                System.out.println("enter the amount");
                balance = sc.nextInt();
                newCustomer.withdrawSavingsAccount(newCustomer.getUserId(), accNo, balance);

            } else if (choice == 3) {
                askUserIdAndAccNo();
                System.out.println("enter the amount");
                balance = sc.nextInt();
                newCustomer.withdrawCurrentAccount(newCustomer.getUserId(), accNo, balance);

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

    public void deposit() {
        int choice = 0;
        try {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            choice = sc.nextInt();
            if (choice == 1) {
                askUserIdAndAccNo();
                System.out.println("enter the amount");
                balance = sc.nextInt();
                newCustomer.depositSavingsAccount(userId, accNo, balance);

            } else if (choice == 2) {
                askUserIdAndAccNo();
                System.out.println("enter the amount");
                balance = sc.nextInt();
                newCustomer.depositCurrentAccount(userId, accNo, balance);

            } else {
                System.out.println("you have given wrong input please please retry");
                withdraw();
            }
        } catch (InputMismatchException inputMismatch) {
            System.out.println("please try again");
            sc.next();
            deposit();
        }

    }

    Customer getDetails() {
        Customer customer = null;
        try {
            System.out.println("enter your userId");
            String userId = System.console().readLine();
            customer = customerList.get(userId);
            if (customer == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("invalid userId");
            getDetails();
        }
        return customer;

    }

    public static void main(String[] args) {
        BankApp newBankApp = new BankApp();
        // newBankApp.createAccount();
        // newBankApp.withdraw();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            System.out.println();
            System.out.println("1) register");
            System.out.println("2) Open a new bank account");
            System.out.println("3) withdraw");
            System.out.println("4) deposit");
            System.out.println();
            System.out.print("Enter choice [1-6]:");
            option = in.nextInt();
            switch (option) {
            case 1:
                System.out.println("enter your name");
                String name = System.console().readLine();
                System.out.println("enter your ph");
                int phoneNumber = in.nextInt();
                newBankApp.userId = newBankApp.register(name, phoneNumber);
                newBankApp.customerList.put(newBankApp.userId, newBankApp.newCustomer);
                break;
            case 2:
                Customer customer = newBankApp.getDetails();
                newBankApp.newCustomer = customer;
                newBankApp.createAccount();
                break;

            case 3:
                customer = newBankApp.getDetails();
                newBankApp.newCustomer = customer;
                newBankApp.withdraw();
                break;

            case 4:
                customer = newBankApp.getDetails();
                newBankApp.newCustomer = customer;
                newBankApp.deposit();
                break;
            }

        } while (option != 6);
        // c1.deposit(200);

    }

}