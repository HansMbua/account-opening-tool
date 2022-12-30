package com.love2code.accountopeningtool.Service;

import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    // inject a repository for accessing and modifying account information

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // method for opening a new account

    public CurrentAccount openAccount(Long customerId, Double initialCredit) {
        // create a new account object and set the customer ID and initial credit
        CurrentAccount account = new CurrentAccount();
        account.setCustomerId(customerId);
        account.setBalance(initialCredit);

        // save the account to the repository and return it
        return accountRepository.save(account);
    }

    // method for retrieving an account by customer ID
    public CurrentAccount getAccount(Long customerId) {
        return accountRepository.findById(customerId).orElse(null);
    }


}
