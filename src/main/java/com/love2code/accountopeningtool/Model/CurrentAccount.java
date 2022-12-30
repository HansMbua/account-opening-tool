package com.love2code.accountopeningtool.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CurrentAccount {

    private double  balance;
    private List<Transaction> transactions;
    public CurrentAccount() {
        this.transactions = new ArrayList<>();
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
