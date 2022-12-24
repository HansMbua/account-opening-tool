package com.love2code.accountopeningtool.Serivice;
import com.love2code.accountopeningtool.Exception.CustomerNotFoundException;
import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import com.love2code.accountopeningtool.Model.Transaction;
import com.love2code.accountopeningtool.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //get all present customers
    public List<Customer> getAllCustomers() {
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
       Customer customer = getCustomerById(customerId);
       // create new Account
       CurrentAccount newAccount = createNewAccount(customerId, initialCredit);
       //add initial transaction
       addInitialTransaction(initialCredit, newAccount);
       customer.getAccounts().add(newAccount);
       // save the new transaction on the current customers account
       customerRepository.save(customer);

    }

    //getting the information of the new transaction
    public Customer getCustomerInfo(Long id) {

        return getCustomerById(id);
    }



    private Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        // checking if Customer is found
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with Id " + customerId + " not found");
        }
        return optionalCustomer.get();
    }

    //create a new account if customer is found
    private CurrentAccount createNewAccount(Long customerId, Double initialCredit) {
        CurrentAccount newAccount = new CurrentAccount();
        newAccount.setInitialCredit(initialCredit);
        newAccount.setcustomerId(customerId);
        return newAccount;
    }

    private void addInitialTransaction(Double initialCredit, CurrentAccount newAccount) {
        // If the initial credit is not 0, perform a transaction on the new account
        if (initialCredit != 0) {
            newAccount.getTransaction().add(new Transaction(initialCredit, "Initial credit"));
        }
    }



}
