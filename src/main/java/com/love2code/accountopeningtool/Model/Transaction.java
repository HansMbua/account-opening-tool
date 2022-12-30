package com.love2code.accountopeningtool.Model;

import java.time.LocalDateTime;

public class Transaction {

//    Random random = new Random();
//    private  Long id = random.nextLong(4);;
    //private  Long id;
    private Long customerId;
    private double initialCredit;
    private String description;
    private LocalDateTime date;
    public Transaction() {
    }

    public Transaction(Long customerId, double initialCredit, String description, LocalDateTime date) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
        this.description = description;
        this.date = date;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
