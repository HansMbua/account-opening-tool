package com.love2code.accountopeningtool.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CurrentAccount {

//    Random random = new Random();
//    private  Long id = random.nextLong(4);;
    private  Long customerId;
    private  long accountNumber;
    private double initialCredit;
    private List<Transaction> transactions;
    public CurrentAccount() {
        this.transactions = new ArrayList<>();
    }

    public void setcustomerId(Long CustomerId) {
        this.customerId = CustomerId;
    }

    public Long getcustomerId() {
        return customerId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getinitialCredit() {
        return initialCredit;
    }

    public void setinitialCredit(double balance) {
        this.initialCredit = balance;
    }



    public List<Transaction> getTransaction() {

        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
