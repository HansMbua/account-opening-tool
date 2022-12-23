package com.love2code.accountopeningtool.Model;

import java.util.Random;

public class Transaction {

//    Random random = new Random();
//    private  Long id = random.nextLong(4);;
    //private  Long id;
    private double initialCreadit;
    private String description;
    public Transaction() {
    }

    public Transaction(double initialCreadit, String description){
        this.initialCreadit =initialCreadit;
        this.description = description;
    }


    public double getAmount() {
        return initialCreadit;
    }

    public void setAmount(double amount) {
        this.initialCreadit = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
