import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ATM {
    float Balance;
   public List<Transaction> transaction=new ArrayList<>();
    int PIN=5674;
//Check if entered pin is correct or not
    public void checkpin() {
        System.out.println("Enter your pin");
        Scanner sc = new Scanner(System.in);
        int EnterPin = sc.nextInt();
        if (EnterPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a Valid Pin");
          checkpin();
        }
    }
//Menu Options
        public void menu(){
            System.out.println("1.Check Balance");
            System.out.println("2.Withdraw Amount");
            System.out.println("3.Deposit Amount");
            System.out.println("4.Transaction History");
            System.out.println("5.Exit");
            System.out.println("Enter Option");
            Scanner sc=new Scanner(System.in);
            int opt=sc.nextInt();
            if(opt==1){
                checkBalance();
            } else if (opt==2) {
                withdraw();
            } else if (opt==3) {
                deposit();
            } else if (opt==4) {
                transaction();
            } else if(opt==5) {
                return;
            }
            else{
                System.out.println("Enter valid option");
            }
        }
//Check Balance
        public void checkBalance(){
            System.out.println("Balance"+ Balance);
            menu();
        }

        public void withdraw(){
            System.out.println("Enter Amount");
            Scanner sc=new Scanner(System.in);
            float amount=sc.nextFloat();
            if(amount>Balance){
                System.out.println("Insufficient Balance");
                menu();
            }
            else {
                Balance=Balance-amount;
                System.out.println("Money Withdraw Successfully");
                transaction.add(new Transaction("withdraw",amount));
                menu();
            }
        }
//Money Deposit
        public void deposit(){
            System.out.println("Enter The Amount");
            Scanner sc=new Scanner(System.in);
            float amount= sc.nextFloat();
            Balance=Balance+amount;
            System.out.println("Money Deposited Successfully");
            transaction.add(new Transaction("deposit",amount));
            menu();
        }
        public void transaction() {
            System.out.println("Transaction History: ");

                if(transaction.isEmpty()) {
                    System.out.println("There is no transaction till now");
                    menu();
                }
                else {
                    System.out.println(transaction.size());
                    for(int i=0;i<transaction.size();i++){
                    System.out.println(transaction.get(i));
                    }
                    menu();
                }
        }
    }
public class ATMMachine {
    public static void main(String[] args) {
    ATM obj=new ATM();
    obj.checkpin();
    }
}