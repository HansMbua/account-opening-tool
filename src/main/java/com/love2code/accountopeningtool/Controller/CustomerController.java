package com.love2code.accountopeningtool.Controller;

import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import com.love2code.accountopeningtool.Serivice.CustomerService;
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

    @RequestMapping("/customer/getCustomers")
    public List<Customer> getAllCustomers(){
        logger.info("in getAllCustomers() ");
        return  customerService.getAllCustomer();
    }

//    @PutMapping("/accounts/{id}")
//    public ResponseEntity<Void> openAccount(@PathVariable Long  id, @RequestParam(defaultValue = "0") double initialCredit){
//        logger.info("in OpenAccount() customer with id: "+id+" initialCredit is : "+initialCredit);
//        customerService.openNewAccount(id,initialCredit);
//        return ResponseEntity.ok().build();
//    }
    @PostMapping("/accounts/")
    public ResponseEntity<Void> openAccount(@RequestBody CurrentAccount currentAccount){

        logger.info("in OpenAccount() customer with id: "+currentAccount.getcustomerId()+" initialCredit is : "+currentAccount.getinitialCredit());
        customerService.openNewAccount(currentAccount.getcustomerId(), currentAccount.getinitialCredit());
        return ResponseEntity.ok().build();
    }

    @RequestMapping("customers/{customerId}")
    public ResponseEntity<Customer> getCustomerInfo(@PathVariable Long customerId){
        logger.info("in getCustomerInfo() ");
        Customer customerInfo = customerService.getCustomerInfo(customerId);
        return ResponseEntity.ok(customerInfo);
    }

    @PostMapping("/customer/")
    public void SaveCustomer(@RequestBody Customer customer){
        logger.info("in createCustomer() and customerName is :  "+customer.getCustomerName());
        customerService.saveCustomer(customer);
    }

//    @DeleteMapping("/customers/{customersId}")
//    public String deleteCustomer(@PathVariable int customersId){
//        customerService.deleteCustomer(customersId);
//        return "Deleted customer id -"+customersId;
//
//    }



}
