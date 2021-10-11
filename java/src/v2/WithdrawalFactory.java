package v2;

public class WithdrawalFactory {
    
    double withdrawAmount;
    double accountBalanceNew;

    public WithdrawalFactory(double withdrawAmount){
        this.withdrawAmount = withdrawAmount;
    }

    public double withdrawMoney(double accountBalanceOld){
        if (accountBalanceOld<withdrawAmount){
            System.out.println("You do not have enough money to withdraw!!");
        }else{
            accountBalanceNew=accountBalanceOld-withdrawAmount;
            return accountBalanceNew;
        }
        return accountBalanceOld;
    }
}
