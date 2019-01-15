import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option;
        Customer c1 = new Customer();
        do {
            System.out.println();
            System.out.println("1) Open a new bank account");
            System.out.println("2) showAccountDetails");
            System.out.println("3) deposit");
            System.out.println("4) withdraw");
            System.out.println();
            System.out.print("Enter choice [1-6]:");
            option = in.nextInt();
            switch (option) {
            case 1:
                c1.createAcount();
                break;
            case 2:
                c1.showAccountDetails();
                break;

            case 3:
                c1.deposit();
                break;

            case 4:
                c1.withdraw();
            }

        } while (option != 6);

    }

}
