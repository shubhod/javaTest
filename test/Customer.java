import java.util.*;
/**
 * 
 */
class Customer
{   private  String  name;
    private   int    phoneNumber;
    private  static  Random rand = new Random();
    private  static  int randomNumber=rand.nextInt(453453534);
    private  String   userId;
    private  int accNo;
    //private  static  int randomNumberforAccount=rand.nextInt(1111);
    List<BankAccount> listOfAccounts;
    Map<String,List<BankAccount>> accounts;

    Customer(String name,int phoneNumber)
        {       
                randomNumber=randomNumber+1;    
                String StringRandomNumber=Integer.toString(randomNumber);
                this.name=name;
                this.phoneNumber=phoneNumber;
                accounts = new HashMap<String,List<BankAccount>>();
                userId=name+StringRandomNumber; 
                System.out.println("your userID is"+" "+userId); 
        }
    private List<BankAccount> getAccountList(String userId)
        {   
            return accounts.get(userId);
        }


    private BankAccount getAccount(int accNo,String userId)
        {   
            BankAccount account=null;
            List<BankAccount> listOfAccounts=getAccountList(userId);
            for(int i=0;i<listOfAccounts.size();i++)
                {   
                    if(accNo==listOfAccounts.get(i).getAccountNo())
                        {
                             account=listOfAccounts.get(i);
                        }

                }
                if(account==null)
                    {
                        System.out.println("account not matched");
                    }
               
                    return account;   
        }

    public void createFixedDepositAccount(int balance,String password,int tenure,String userId)
        {   
             
            
            if(getAccountList(userId)!=null)
                {
                    listOfAccounts=getAccountList(userId);
                    accNo=1+listOfAccounts.get(listOfAccounts.size()-1).getAccountNo();
                    
                }
            else
                {
                    listOfAccounts=new ArrayList<>();
                    accNo=rand.nextInt(111134);
                }
            FixedDepositAccount newFixedDepositAccount=new FixedDepositAccount(balance,password,tenure,accNo);
            listOfAccounts.add(newFixedDepositAccount);
            accounts.put(userId,listOfAccounts);
            System.out.println("your accNo is"+accNo);
            
        }
    public void withdrawFixedDepositAccount(int balance,String password,int tenure,String accNo,String userId)
        {   
                         getAccount();
                    

        }

}