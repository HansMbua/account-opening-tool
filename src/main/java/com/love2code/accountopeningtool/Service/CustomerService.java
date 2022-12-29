package com.love2code.accountopeningtool.Service;
import com.love2code.accountopeningtool.Exception.CustomerExistException;
import com.love2code.accountopeningtool.Exception.CustomerNotFoundException;
import com.love2code.accountopeningtool.Exception.initialCreditError;
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
        //get customers from customerRepository add them to customers list then return the list
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    // create new Customers
    public Customer saveCustomer(Customer theCustomer) {

        if (customerRepository.findById(theCustomer.getCustomerId()).isPresent()){
            throw new CustomerExistException("the customer with that id already exit");
        }else {
            return customerRepository.save(theCustomer);
        }
    }

   public void openNewAccount(Long customerId, Double initialCredit) {

       //get customer by id
       Customer customer = getCustomerById(customerId);
       // create new Account
       CurrentAccount newAccount = createNewAccount(customerId, initialCredit);
       //add initial transaction
       addInitialTransaction(customerId,initialCredit, newAccount);
       customer.getAccounts().add(newAccount);
       // save the new transaction on the current customers account
       customerRepository.save(customer);

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

    //create a new account if customer is found
    private CurrentAccount createNewAccount(Long customerId, Double initialCredit) {
            if (initialCredit != 0){
                CurrentAccount newAccount = new CurrentAccount();
                newAccount.setBalance(initialCredit);
                newAccount.setcustomerId(customerId);
                return newAccount;

            }else{
                 throw new initialCreditError("account with initial credit: "+initialCredit+" cannot be created");
            }

    }

    private void addInitialTransaction(Long customerId , Double initialCredit, CurrentAccount newAccount) {
        // If the initial credit is not 0, perform a transaction on the new account
        if (initialCredit != 0) {
            newAccount.getTransaction().add(new Transaction(customerId,initialCredit, "Initial credit"));
        }
    }



}
