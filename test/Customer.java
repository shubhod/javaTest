import java.util.*;
/**
 * 
 */
class Customer
{   private  String  name;
    private  String  accountId;
    private   int    phoneNumber;
    private  static  Random rand = new Random();
    private  static  int randomNumber=rand.nextInt(111150);
    private  String   userId;
    //private  static  int randomNumberforAccount=rand.nextInt(1111);
    List<Object> listOfAccounts;
    Map<String,List<Object>> accounts;

    Customer(String name,int phoneNumber)
        {       
                randomNumber=randomNumber+1;    
                String StringRandomNumber=Integer.toString(randomNumber);
                this.name=name;
                this.phoneNumber=phoneNumber;
                accounts = new HashMap<String,List<Object>>();
                userId=name+StringRandomNumber; 
                System.out.println("your userID is"+" "+userId); 
        }
    private List<Object> getAccountList(String userId)
        {   
            return accounts.get(userId);
        }
    private Object getAccount(String accNo,String userId)
        {   
            Object account=null;
            List<Object> listOfAccounts=getAccountList(userId);
            for(int i=0;i<listOfAccounts.size();i++)
                {   
                    if(accNo.equals(listOfAccounts.get(i).getAccountNo()))
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

    public void createFixedDepositAccount(int balance,String password,int tenure)
        {   
            String StringRandomNumber=Integer.toString(randomNumber+rand.nextInt(111150));       
            String accNo="accFD"+StringRandomNumber;
            FixedDepositAccount newFixedDepositAccount=new FixedDepositAccount(balance,password,tenure,accNo);
            if(getAccountList(userId)!=null)
                {
                    listOfAccounts=getAccountList(userId);
                }
            else
                {
                    listOfAccounts=new ArrayList<>();
                }
            listOfAccounts.add(newFixedDepositAccount);
            accounts.put(userId,listOfAccounts);
            System.out.println("your accNo is"+accNo);
            
        }
    public void withdrawFixedDepositAccount(int balance,String password,int tenure,String accNo)
        {
                

        }
    


}