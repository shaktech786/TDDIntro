package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    Account account;

    private void setUpAccount() {
        account = new Account(100);
    }
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        setUpAccount();
        account.deposit(50);
        assertThat(account.getBalance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        setUpAccount();
        account.withdraw(50);
        assertThat(account.getBalance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account = new Account(50);
        account.withdraw(100);
        assertThat(account.getBalance(), is(50));
    }
}
