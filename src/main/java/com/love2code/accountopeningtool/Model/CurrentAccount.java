package com.love2code.accountopeningtool.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CurrentAccount {

    Random random = new Random();
    private  Long id = random.nextLong(4);;
    private  long accountNumber;
    private double balance;
    private List<Transaction> transactions;
    public CurrentAccount() {
        this.transactions = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public List<Transaction> getTransaction() {

        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
