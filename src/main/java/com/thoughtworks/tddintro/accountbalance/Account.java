package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by sbhamani on 7/29/2016.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    public void deposit(int i) {
        balance += i;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int i) {
        if (i < balance)
        balance -= i;
    }
}
