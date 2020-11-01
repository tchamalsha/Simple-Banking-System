package com.company;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //getting the name of the holder
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWelcome to console Banking!!!");
        System.out.println("________________________________________");
        System.out.println("----------------------------------------");
        System.out.print("Enter your name to continue: ");
        String name = scan.nextLine();

        //initializing person
        Person person1 = new Person(name);
        person1.GetAccountNumber();

        //initializing account
        Account account1= new Account(name,person1.accountNumber);

        //banking
        boolean process=true;
        while (process){
            System.out.println("----------------------------------------");
            System.out.println("1.Check your balance" +
                    "\n" +
                    "2.Make a deposit" +
                    "\n" +
                    "3.Make a withdrawal" +
                    "\n" +
                    "4.Calculate Interest" +
                    "\n" +
                    "5.Print statement" +
                    "\n" +
                    "6.Check previous transaction." +
                    "\n" +
                    "7.Exit the application\n");
            System.out.print("Select from the menu:");
            int checkType = scan.nextInt();
            System.out.println("\n----------------------------------------");
            switch (checkType){
                case 1:
                    account1.checkBalance();
                    break;
                case 2:
                    account1.makeDeposit();
                    break;
                case 3:
                    account1.makeWithdrawal();
                    break;
                case 4:
                    account1.checkInterest();
                    break;
                case 5:
                    account1.Statement();
                    break;
                case 6:
                    account1.setPreviousTransaction();
                    break;
                case 7:
                    System.out.println("________________________________________");
                    System.out.println("Thank you for banking with us.Have a nice day!!");
                    process=false;
                    break;
                default:
                    System.out.println("Please enter relevant number");

                }
            }
        }


    }

