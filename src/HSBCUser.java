import java.util.Objects;
import java.util.UUID;

public class HSBCUser implements BankInterface {
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public HSBCUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HSBCUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance += amount;
        return "deposited successfully "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String Enteredpassword) {
        if(Objects.equals(Enteredpassword,password)){
            if(amount > balance){
                return "Insufficient balance";
            }else{
                balance -=amount;
                return "remaining balance "+balance;
            }
        }else{
            return "wrong password daw";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
