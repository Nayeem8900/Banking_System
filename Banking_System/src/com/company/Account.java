package com.company;

import java.util.Scanner;

/**
 * Created by Nayeem on 11/5/2016.
 */

public class Account {

    String memberName,accountType;
    int accountNumber;
    private double accountBalance;

    Scanner Scan =new Scanner(System.in);

    public Account(String memberName, int accountNumber, String accountType, double accountBalance) {
        this.memberName = memberName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposite()
    {
        System.out.println("please depositable ammount");
        double x=Scan.nextDouble();
        accountBalance=accountBalance+x;
        System.out.println("You deposite "+x);
       // System.out.println("Your Account Balance is "+accountBalance);
    }

    public void withdraw()
    {
        if(accountBalance<=0)
        {
            System.out.println("Your Balance is zero");
            return;
        }
        System.out.println("enter your balance");
        double x=Scan.nextDouble();
        if(accountBalance<x)
        {
            System.out.println("you dont have that much balance");
        }
        else
        {
            accountBalance-=x;
            System.out.println("You withdraw "+x);
            System.out.println("Your balance is "+accountBalance);

        }
    }

    public double balance()
    {

        return accountBalance;
    }

}
