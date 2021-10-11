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

        //initialize transaction finder
        TransactionFinder transactionFinder=new TransactionFinder();

        //interest calculator
        InterestCalculator interestCalculator=new InterestCalculator();


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
            interestCalculator.setInterest(account.getAccountBalance());
            switch (actionNumber){
                case 1:
                    //check account balance
                    AccountBalanceChecker accountBalanceChecker=new AccountBalanceChecker(account.getAccountBalance());
                    accountBalanceChecker.checkAccountBalance();
                    transactionFinder.setTransaction("Checked account Balance");
                    break;
                case 2:
                    //make a deposit
                    System.out.println("Enter amount to deposit: ");
                    double depositAmount=scanner.nextDouble();
                    Depositor depositor=new Depositor(depositAmount);
                    account.setAccountBalance(depositor.depositMoney(account.getAccountBalance()));
                    transactionFinder.setTransaction("Deposited Money to the account.");
                    break;
                case 3:
                    //make a withdrawal
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount=scanner.nextDouble();
                    WithdrawalFactory withdrawalFactory=new WithdrawalFactory(withdrawAmount);
                    account.setAccountBalance(withdrawalFactory.withdrawMoney(account.getAccountBalance()));
                    transactionFinder.setTransaction("Withdraw money from account.");
                    break;
                case 4:
                    //calculate interest
                    interestCalculator.calculateInterest(account.getAccountBalance());
                    transactionFinder.setTransaction("Calculated interest.");
                    break;
                case 5:
                    //print statement
                    StatementPrinter statementPrinter=new StatementPrinter();
                    statementPrinter.printStatement(account.accountNumber,account.getAccountBalance(),transactionFinder.getTransaction(),interestCalculator.getInterest());
                    transactionFinder.setTransaction("Printed statement.");
                    break;
                case 6:
                    //previous transaction
                    transactionFinder.printPreviousTransaction();
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
