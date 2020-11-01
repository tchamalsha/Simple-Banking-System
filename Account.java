package com.company;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Account {
    Scanner scanner= new Scanner(System.in);
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
    String accountHolder;
    long accountNumber;
    double accountBalance=0;
    String previousTransaction;


    Account(String accountHolder,long accountNumber){
        this.accountHolder=accountHolder;
        this.accountBalance=accountBalance;
        this.accountNumber=accountNumber;
        System.out.println("Start your banking journey by now.!!");
    }

    void checkBalance(){
        String balance =currency.format(this.accountBalance);
        System.out.println("Your account balance is: "+balance);
        this.previousTransaction="Checked account balance.";
    }
    void makeDeposit(){
        System.out.println("Enter the amount to deposit: ");
        long amount= scanner.nextLong();
        this.accountBalance=amount+this.accountBalance;
        System.out.println("You have successfully deposited your money!!");
        checkBalance();
        this.previousTransaction="deposited "+currency.format(amount)+" amount of money.";
    }
    void makeWithdrawal(){
        System.out.println("Enter amount to withdraw: ");
        long amount= scanner.nextLong();
        if(amount>this.accountBalance){
            System.out.println("you have not enough account balance to withdraw money!!");
            checkBalance();
        }
        else {
            this.accountBalance=this.accountBalance-amount;
            System.out.println("You have successfully withdrawed your money!!");
            checkBalance();
            this.previousTransaction="withdraw "+currency.format(amount)+" amount of money.";
        }
    }
    void checkInterest(){
        float interest = (float) (this.accountBalance*3/100);
        System.out.println("Your annual interest is: "+interest);
        this.previousTransaction="Checked the interest";
    }
    void Statement(){
        System.out.println("Here is the statement.");
        Date date =new Date();
        this.previousTransaction="printed statement";
        System.out.format("|%20s|%20s|%20s|\n","Date","Account Number","Account Balance");
        System.out.format("|%20s|%20d|%20s|\n",dateFormat.format(date),this.accountNumber,currency.format(this.accountBalance));
    }
    void setPreviousTransaction(){
        System.out.println(previousTransaction);
    }
}
