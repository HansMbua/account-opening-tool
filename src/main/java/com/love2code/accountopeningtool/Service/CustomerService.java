package com.love2code.accountopeningtool.Service;
import com.love2code.accountopeningtool.Exception.CustomerExistException;
import com.love2code.accountopeningtool.Exception.CustomerNotFoundException;
import com.love2code.accountopeningtool.Exception.InitialCreditError;
import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import com.love2code.accountopeningtool.Repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomerService {
    @Autowired
    private repository customerRepository;

    //get all present customers
//    public List<Customer> getAllCustomers() {
//        List<Customer> customers = new ArrayList<>();
//        //get customers from customerRepository add them to customers list then return the list
//        customerRepository.findAll().forEach(customers::add);
//        return customers;
//    }

    // create new Customers
    public Customer saveCustomer(Customer theCustomer) {
     // check if customer with id is present
        if (customerRepository.findById(theCustomer.getId()).isPresent()){
            throw new CustomerExistException("the customer with that id already exit");
        }else {
            return customerRepository.save(theCustomer);
        }
    }

    //getting the information of the new transaction
    public Customer getCustomerInfo(Long id) {

        return getCustomerById(id);
    }



    private Customer getCustomerById(Long customerId) {
        //get customer by id
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        // checking if Customer is found
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with Id " + customerId + " not found");
        }
        return optionalCustomer.get();
    }

}
