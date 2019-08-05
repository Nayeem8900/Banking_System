package com.company;

/**
 * Created by Nayeem on 11/5/2016.
 */
public class SavingsAccount extends Account
{

    double interest = 5;
    double accountLimit=500;

    public SavingsAccount(String memberName, int accountNumber, String accountType, double accountBalance)
    {
        super(memberName, accountNumber, accountType, accountBalance);
    }



    @Override
    public double balance()
    {
       double x=getAccountBalance()/100;
        x=x*interest;
        x=getAccountBalance()+x;
       return x;


    }

    @Override
    public void withdraw() {
        if(balance()<=0)
        {
            System.out.println("Your Balance is zero");
            return;
        }
        else if(balance()<=accountLimit)
        {
            System.out.println("you cannot withdraw this last 500");
            return;

        }
        System.out.println("enter your ammount");
        double x=Scan.nextDouble();
        if(x<accountLimit)
        {
            System.out.println("withdrawal limit is 500");
        }

        else if(x>balance())
        {
            System.out.println("you dont have that much balance");
        }
        else if((balance()-x)<accountLimit)
        {
            System.out.println("you cannot withdraw last 500");
        }
        else
        {
            double y =balance()-x;
            setAccountBalance(y);
            System.out.println("you withdraw "+x);

          //  x=this.balance();
           // System.out.println("your balance is "+x+" with interest");
        }
    }

    @Override
    public void deposite() {
        super.deposite();
       // double y=this.balance();
      //  System.out.println("your balance is "+y+" with interest");

    }
}
