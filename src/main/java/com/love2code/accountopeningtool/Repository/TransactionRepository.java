package com.love2code.accountopeningtool.Repository;
import com.love2code.accountopeningtool.Model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class TransactionRepository  {
    private Logger logger = Logger.getLogger(getClass().getName());
    // find a list of transactions by account ID
    List<Transaction> transactions;

    public TransactionRepository(){
        this.transactions = new ArrayList<>(Arrays.asList(

        ));

    }


    public Transaction save(Transaction transactions) {
        this.transactions.add(transactions);
        return transactions;
    }

    public Optional<Transaction> findByAccountId(Long id) {
        logger.info("in findByAccountId and customerId is :  "+id);
        return transactions.stream().filter(t -> t.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        transactions.removeIf(T -> T.getId().equals(id));
    }
}
