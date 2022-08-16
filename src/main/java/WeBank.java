import java.util.Scanner;

public class WeBank {
    public static void  main(String[] args){
        System.out.println("Welcome to WeBank");
        System.out.println("**********************************************");
        BankAccount cus1 = new BankAccount("Vhushavhelo", "C0001");
        cus1.showMenu();

    }

}

class BankAccount{
    double balance;
    double previousTransaction;
    String customerName;
    String customerId;

    BankAccount (String cname,String cid){
        customerName = cname;
        customerId = cid;

    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }

    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " +previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn: " +Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to WeBank " +customerName);
        System.out.println("Your ID is " +customerId);
        System.out.println("\n");

        do{
            System.out.println("==============================================");
            System.out.println("Enter an option");
            System.out.println("==============================================");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            option = scanner.next().toUpperCase().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("---------------------------");
                    System.out.println("Balance = R" +balance);
                    System.out.println("---------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("---------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("---------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("---------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("---------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("***************************");
                    break;

                default:
                    System.out.println("Invalid Selection! Please try again!");
                    break;
            }
        }while(option!= 'E');
        System.out.println("Thank you for using WeBank");
    }
}