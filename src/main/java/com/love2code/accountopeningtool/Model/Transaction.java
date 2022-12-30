package com.love2code.accountopeningtool.Model;

import java.time.LocalDateTime;

public class Transaction {


    private Long id;

    private Double amount;

    private String description;

    private LocalDateTime date;
    public Transaction() {


    }

    public Transaction(Long id, Double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
