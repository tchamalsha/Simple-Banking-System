package v2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Console Banking!!");
        System.out.println("*************************************************");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter your name to continue: ");

        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();

        //initialize a person
        Person person=new Person(name);
        person.generateAccountNumber();

        //initializing an account
        Account account=new Account(person.accountNumber, person.name);

        boolean action=true;
        while(action){
            System.out.println("*************************************************");
            System.out.println("1.Check your balance\n" +
                    "2.Make a deposit\n" +
                    "3.Make a withdrawal\n" +
                    "4.Calculate Interest\n" +
                    "5.Print statement\n" +
                    "6.Check previous transaction.\n" +
                    "7.Exit the application");
            System.out.println("Select from the menu: ");
            int actionNumber=scanner.nextInt();
            System.out.println("-------------------------------------------------");
            switch (actionNumber){
                case 1:
                    //check account balance
                    AccountBalanceChecker accountBalanceChecker=new AccountBalanceChecker(account.getAccountBalance());
                    accountBalanceChecker.checkAccountBalance();
                    break;
                case 2:
                    //make a deposit
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount=scanner.nextDouble();
                    Depositor depositor=new Depositor(depositAmount);
                    account.setAccountBalance(depositor.depositMoney(account.getAccountBalance()));
                    break;
                case 3:
                    //make a withdrawal
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount=scanner.nextDouble();
                    WithdrawalFactory withdrawalFactory=new WithdrawalFactory(withdrawAmount);
                    account.setAccountBalance(withdrawalFactory.withdrawMoney(account.getAccountBalance()));
                    break;
                case 4:
                    //calculate interest
                    InterestCalculator interestCalculator=new InterestCalculator();
                    interestCalculator.calculateInterest(account.getAccountBalance());
                    break;
                case 5:
                    //print statement
                    StatementPrinter statementPrinter=new StatementPrinter();
                    statementPrinter.printStatement(account.accountNumber,account.getAccountBalance());
                    break;
                case 7:
                    action=false;
                    System.out.println("Thanks for banking with us. !!");
                    break;
                default:
                    System.out.println("Please select number from 1 to 7!!");
            }
        }





    }
}
