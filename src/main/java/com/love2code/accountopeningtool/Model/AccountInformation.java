package com.love2code.accountopeningtool.Model;

import java.util.Optional;

public class AccountInformation {

    private Optional<CurrentAccount> account;

    private Optional<Transaction> transactions;
    private Customer customer;

    public AccountInformation() {
    }

    public Optional<CurrentAccount> getAccount() {
        return account;
    }

    public void setAccount(Optional<CurrentAccount> account) {
        this.account = account;
    }

    public Optional<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Optional<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
