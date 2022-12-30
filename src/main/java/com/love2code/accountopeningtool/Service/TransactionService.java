package com.love2code.accountopeningtool.Service;

import com.love2code.accountopeningtool.Model.Transaction;
import com.love2code.accountopeningtool.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
    // inject a repository for accessing and modifying transaction information
    @Autowired
    private TransactionRepository transactionRepository;

    // method for adding a transaction to an account
    public Transaction addTransaction(Long accountId, Double amount, String description) {
        // create a new transaction object and set the account ID, amount, and type
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDateTime.now());
        transaction.setId(1l);
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setDescription(description);

        // save the transaction to the repository and return it
        return transactionRepository.save(transaction);
    }

    // method for retrieving a list of transactions for a given account
    public Optional<Transaction> getTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
