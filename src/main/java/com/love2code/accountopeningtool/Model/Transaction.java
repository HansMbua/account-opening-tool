package com.love2code.accountopeningtool.Model;

import java.util.Random;

public class Transaction {

    Random random = new Random();
    private  Long id = random.nextLong(4);;
    private double amount;
    private String description;
    public Transaction() {
    }

    public Transaction(double amount, String description){
        this.amount = amount;
        this.description = description;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
