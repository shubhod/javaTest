import java.util.*;
class BankApp
{ 
    Map<String,Customer> customerList=new HashMap<>();
    Customer newCustomer;
    private String password;
    private int balance;
    private String userId;
    Scanner sc=new Scanner(System.in);
     BankApp(String name,int phoneNumber)
        {
            newCustomer=new Customer(name,phoneNumber);
                
        }
    private void askDetails()
        {
            System.out.println("enter the balance");
            balance=sc.nextInt();
            System.out.println("enter the password");
            password=System.console().readLine();
        }
    public void createAccount()
        {
            System.out.println("press 1 to open savings account or 2 FD or 3 currentAccount");
            int choice=sc.nextInt();
            System.out.println("enter the userId");
            userId=System.console().readLine();
            if(choice==1)
                {   askDetails();
                    System.out.println("enter the tenure");
                    int tenure=sc.nextInt();
                    newCustomer.createFixedDepositAccount(balance,password,tenure,userId);
                }
            else
                if(choice==2)
                {
                    askDetails();
                    //newCustomer.createSavingsAccount();
                }
            else
                {
                   askDetails();
                   //newCustomer.createCurrentAccount();
                }
           

        }
                public static void main(String []args)
                    {
    
                        BankApp newBankApp=new BankApp("gjg",213123123);
                        newBankApp.createAccount();                            
                    }
                    
}