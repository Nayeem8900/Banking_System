package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nayeem on 11/5/2016.
 */
public class Bank {
    public static void main(String[] args)
    {
        int choice,accserial=0,accnumber;
        String name,trade;
        double initial;
        Scanner sc=new Scanner(System.in);
        Account Acc[]=new Account[10];

        Random r=new Random();

        while(true)
        {
            System.out.println("---------------Menu--------------");
            System.out.println("1->Create a Account");
            System.out.println("2->Deposite");
            System.out.println("3->Withdraw");
            System.out.println("4->Balance");
            System.out.println("---------------------------------");
            

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println("1->Savings Account");
                    System.out.println("2->Current Account");
                    int y = sc.nextInt();
                    sc.nextLine();
                    switch (y)
                    {
                        case 1:
                            accnumber=r.nextInt(99999);
                            System.out.println("Name please");
                            name=sc.nextLine();
                            System.out.println("Your initial balance");
                            initial=sc.nextDouble();
                            Acc[accserial]=new SavingsAccount(name,accnumber,"Savings Account",initial);
                            System.out.println("your account is created");
                            System.out.println("your account number is "+accnumber);
                            accserial++;
                            break;
                        case 2:
                            accnumber=r.nextInt(99999);
                            System.out.println("Name please");
                            name=sc.nextLine();
                            System.out.println("tradelicense number please");
                            trade=sc.nextLine();
                            System.out.println("Your initial balance");
                            initial=sc.nextDouble();
                            Acc[accserial]=new CurrentAccount(name,accnumber,"Current Account",initial,trade);
                            System.out.println("your account is created");
                            System.out.println("your account number is "+accnumber);
                            accserial++;
                            break;
                        default:
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Account Number Please");
                    accnumber=sc.nextInt();
                    int i;
                    for(i=0;i<accserial;i++)
                    {
                        if(Acc[i].accountNumber==accnumber)
                        {
                            System.out.println("Its a "+Acc[i].accountType);
                            int j;
                            System.out.println("Do you want to know Balance before and after dposite?");
                            System.out.println("1->Yes");
                            System.out.println("2->No");
                            j=sc.nextInt();
                            switch(j)
                            {
                                case 1 :
                                    double x;
                                    x=Acc[i].balance();
                                    System.out.println("Balance is "+x);

                                    Acc[i].deposite();
                                    x=Acc[i].balance();
                                    System.out.println("Balance is "+x);

                                    break;
                                case 2:
                                    Acc[i].deposite();
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
                            break;
                        }
                    }
                    if(i>=accserial)
                    {
                        System.out.println("Invalid Account");
                    }
                    break;




                case 3:
                    System.out.println("Account Number Please");
                    accnumber=sc.nextInt();
                    for(i=0;i<accserial;i++)
                    {
                       if(Acc[i].accountNumber==accnumber)
                       {
                           System.out.println("Its a "+Acc[i].accountType);
                           int j;
                           System.out.println("Do you want to know Balance before and after withdraw?");
                           System.out.println("1->Yes");
                           System.out.println("2->No");
                           j=sc.nextInt();
                           switch(j)
                           {
                               case 1 :
                                   double x;
                                   x=Acc[i].balance();
                                   System.out.println("Balance is "+x);

                                   Acc[i].withdraw();

                                   x=Acc[i].balance();
                                   System.out.println("Balance is "+x);

                                   break;
                               case 2:
                                   Acc[i].withdraw();
                                   break;
                               default:
                                   System.out.println("Invalid Input");
                                   break;
                           }
                           break;

                       }
                    }
                    if(i>=accserial)          //line gula thik korte hoibo
                    {
                        System.out.println("Invalid Account");
                    }
                    break;


                case 4 :
                    System.out.println("Account Number Please");
                    accnumber=sc.nextInt();
                    for(i=0;i<accserial;i++)
                    {
                        if(Acc[i].accountNumber==accnumber)
                        {
                            System.out.println("Its a "+Acc[i].accountType);
                            double x;
                            x=Acc[i].balance();
                            System.out.println("Balance is "+x);

                           break;
                        }
                    }
                    if(i>=accserial)
                    {
                        System.out.println("Invalid Account");
                    }
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;

            }
        }
    }
}
