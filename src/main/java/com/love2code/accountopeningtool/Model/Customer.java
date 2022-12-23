package com.love2code.accountopeningtool.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
//    Random random = new Random();
//    private  Long id = random.nextLong(4);;
   private  Long CustomerId;
    private String customerName;
    private String customerSurname;
    private List<CurrentAccount> accounts;

    public Customer() {
      this.accounts = new ArrayList<>();
    }


    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        this.CustomerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public List<CurrentAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CurrentAccount> accounts) {
        this.accounts = accounts;
    }
}
