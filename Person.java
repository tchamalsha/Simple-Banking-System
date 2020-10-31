package com.company;

import java.text.NumberFormat;

public class Person {
    String name;
    long accountNumber;


    Person(String name){
        this.name=name;
        System.out.println("Person initialized. Hello "+name);
    }
    long GetAccountNumber(){
        long randomNumber =Math.round(Math.random()*((1000000-100000)+1)+100000);
        this.accountNumber=randomNumber;
        System.out.println("Your account number is: "+accountNumber);
        return accountNumber;
    }

}
