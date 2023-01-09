package com.love2code.accountopeningtool.Controller;
import com.love2code.accountopeningtool.Exception.InitialCreditError;
import com.love2code.accountopeningtool.Model.*;
import com.love2code.accountopeningtool.Service.AccountService;
import com.love2code.accountopeningtool.Service.CustomerService;
import com.love2code.accountopeningtool.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public void openAccount(@RequestBody OpenAccountRequest request) {
        // open a new account using the account service
        logger.info("initial credit: "+request.getInitialCredit());
        CurrentAccount account = accountService.openAccount(request.getCustomerId(), request.getInitialCredit());

        // if the initial credit is not 0, add a transaction to the account using the transaction service
        if (request.getInitialCredit() != 0) {
            transactionService.addTransaction(new Transaction(account.getCustomerId(),account.getBalance(),"deposit"));
        }else{
            throw new InitialCreditError("initial credit cannot be 0");
        }

    }

    @PostMapping("/customers")
    public void SaveCustomer(@RequestBody Customer customer){
        logger.info("in createCustomer() and customerName is :  "+customer.getFirstName());
        customerService.saveCustomer(customer);
    }


    @GetMapping("/{customerId}")
    public AccountInformation getAccountInformation(@PathVariable Long customerId) {
        // retrieve the account using the account service
        Customer customer = customerService.getCustomerInfo(customerId);

        // retrieve the account using the account service
        CurrentAccount account = accountService.getAccount(customerId);


        // retrieve the transaction history using the transaction service
        Optional<Transaction> transactions = transactionService.getTransactions(account.getCustomerId());

        // create a response object and set the account and transaction information
        AccountInformation info = new AccountInformation();
        info.setCustomer(customer);
        info.setAccount(account);
        info.setTransactions(transactions);

        // return the information
        return info;
    }




}
