package v2;

public class InterestCalculator {

    double interest;

    public void calculateInterest(double accountBalance){
        interest=accountBalance*0.12;
        System.out.println("Your annual interest is "+interest);
    }


}
