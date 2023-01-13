import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name,balance,password to create an account");

        // CREATE USER
        String name = sc.next();
        double balance = sc.nextDouble();
        String password = sc.next();

        HSBCUser user = new HSBCUser(name,balance,password);

        System.out.println("Your Account No -  " + user.getAccountNo());
        //ADD MONEY
        System.out.println("Enter how much you want to deposit");
        System.out.println(user.addMoney(sc.nextInt()));

        //WITHDRAW MONEY
        System.out.println("Enter how much you want to withdraw");
        int money = sc.nextInt();
        System.out.println("enter your pin code");
        String pass = sc.next();
        System.out.println(user.withdrawMoney(money,pass));

        //RATEOFINTERST

        System.out.println("This is your ROI "+user.calculateInterest(10));
    }
}