package v2;

public class Account {

    long accountNumber;
    String accountHolder;
    double accountBalance=0.00;


    public Account(long accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        System.out.println("Start banking from here!! ");
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
