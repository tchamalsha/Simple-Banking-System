package v2;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatementPrinter {
    DateFormat dateFormat=new SimpleDateFormat("dd/mm/yy");
    NumberFormat currency=NumberFormat.getCurrencyInstance();
    Date date;

    public void printStatement(long accountNumber,Double accountBalance,String previousTransaction,double interest){
        date=new Date();
        System.out.println("This is your account statement!!");
        System.out.format("|%20s|%20s|%20s|%40s|%20s|\n","Date","Account Number","Account Balance","Previous Transaction","Annual Interest");
        System.out.format("|%20s|%20d|%20s|%40s|%20s|\n",dateFormat.format(date),accountNumber,currency.format(accountBalance),previousTransaction,currency.format(interest));

    }

}
