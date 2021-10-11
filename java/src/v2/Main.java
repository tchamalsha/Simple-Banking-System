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

        //check account balance
        AccountBalanceChecker accountBalanceChecker=new AccountBalanceChecker(account.getAccountBalance());
        accountBalanceChecker.checkAccountBalance();


    }
}
