package com.love2code.accountopeningtool.Controller;
import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import com.love2code.accountopeningtool.Model.Transaction;
import com.love2code.accountopeningtool.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        logger.info("in getAllCustomers() ");
        return  customerService.getAllCustomers();
    }
    @PostMapping("/accounts")
    public ResponseEntity<Void> openAccount(@RequestBody Transaction transaction){

        logger.info("in OpenAccount() customer with id: "+transaction.getCustomerId()+" InitialCreditError is : "+transaction.getInitialCredit());
        customerService.openNewAccount(transaction.getCustomerId(), transaction.getInitialCredit());
        return ResponseEntity.ok().build();
    }

    @GetMapping("customers/{customerId}")
    public ResponseEntity<Customer> getCustomersInfo(@PathVariable Long customerId){
        logger.info("in getCustomerInfo() ");
        Customer customerInfo = customerService.getCustomerInfo(customerId);
        return ResponseEntity.ok(customerInfo);
    }

    @PostMapping("/customers")
    public void SaveCustomer(@RequestBody Customer customer){
        logger.info("in createCustomer() and customerName is :  "+customer.getCustomerName());
        customerService.saveCustomer(customer);
    }



}
