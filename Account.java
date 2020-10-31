package com.company;


import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Account {
    Scanner scanner= new Scanner(System.in);
    String accountHolder;
    long accountNumber;
    double accountBalance=0;

    Account(String accountHolder,long accountNumber){
        this.accountHolder=accountHolder;
        this.accountBalance=accountBalance;
        this.accountNumber=accountNumber;
        System.out.println("Account initialized!!");
    }

    void checkBalance(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String balance =currency.format(this.accountBalance);
        System.out.println("Your account balance is: "+balance);
    }
    void makeDeposit(){
        System.out.println("Enter the amount to deposit: ");
        long amount= scanner.nextLong();
        this.accountBalance=amount+this.accountBalance;
        System.out.println("You have successfully deposited your money!!");
        checkBalance();
    }
    void makeWithdrawal(){
        System.out.println("Enter amount to withdraw: ");
        long amount= scanner.nextLong();
        this.accountBalance=this.accountBalance-amount;
        System.out.println("You have successfully withdrawed your money!!");
        checkBalance();
    }
    void checkInterest(){
        float interest = (float) (this.accountBalance*3/100);
        System.out.println("Your annual interest is: "+interest);
    }
    void Statement(){
        System.out.println("Here is statement.");
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Date date =new Date();
        System.out.format("|%20s|%20s|%20s|\n","Date","Account Number","Account Balance");

        System.out.format("|%20s|%20d|%20s|\n",dateFormat.format(date),this.accountNumber,currency.format(this.accountBalance));
    }
}
