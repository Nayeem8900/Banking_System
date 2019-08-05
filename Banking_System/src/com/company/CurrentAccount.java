package com.company;

/**
 * Created by Nayeem on 11/5/2016.
 */
public class CurrentAccount extends Account
{

    String tradelicense;
    public CurrentAccount(String memberName, int accountNumber, String accountType, double accountBalance ,String tradelicense)
    {
        super(memberName, accountNumber, accountType, accountBalance);
        this.tradelicense=tradelicense;
    }


}
