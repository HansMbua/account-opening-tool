package com.love2code.accountopeningtool.Serivice;

import com.love2code.accountopeningtool.Exception.CustomerNotFoundException;
import com.love2code.accountopeningtool.Exception.customerErrorRespond;
import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import com.love2code.accountopeningtool.Model.Transaction;
import com.love2code.accountopeningtool.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.logging.Logger;

@Service
public class CustomerService {
    // customers storage
    private Transaction transaction = new Transaction();
    private Customer customer = new Customer();

    @Autowired
    private CustomerRepository customerRepository;

    //get all present customers
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }


    // create new Customers
    public Customer saveCustomer(Customer theCustomer) {

        return customerRepository.save(theCustomer);

    }
   public void openNewAccount(Long customerId, Double initialCredit) {

        //get customer by id
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        // checking if Customer is found
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with Id " + customerId + " not found");
        }
        //create a new account if customer is found
        Customer customer = optionalCustomer.get();
        CurrentAccount newAccount = new CurrentAccount();
        newAccount.setBalance(initialCredit);

        // If the initial credit is not 0, perform a transaction on the new account
        if (initialCredit != 0) {
            newAccount.getTransaction().add(new Transaction(initialCredit, "Initial credit"));

        }
        // save the new transaction on the current customers account

        customer.getAccounts().add(newAccount);
        customerRepository.save(customer);

    }

    //getting the information of the new transaction
    public Customer getCustomerInfo(Long id) {

        Customer presentCustomer;
        Optional<Customer> theCustomer = customerRepository.findById(id);
        if (theCustomer.isPresent()) {
            presentCustomer = theCustomer.get();
        } else {
            throw new CustomerNotFoundException("the customer was not found");
        }
        return presentCustomer;
    }


    @ExceptionHandler
    public ResponseEntity<customerErrorRespond> handleException(CustomerNotFoundException exception) {

        // create a customer respond error
        customerErrorRespond error = new customerErrorRespond();
        error.setMessage(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
