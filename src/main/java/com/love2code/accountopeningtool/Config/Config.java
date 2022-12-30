package com.love2code.accountopeningtool.Config;

import com.love2code.accountopeningtool.Repository.TransactionRepository;
import com.love2code.accountopeningtool.Repository.AccountRepository;
import com.love2code.accountopeningtool.Repository.CustomerRepository;
import com.love2code.accountopeningtool.Repository.repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

   @Bean
    public repository customerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public AccountRepository accountRepository(){
       return new AccountRepository();
    }

    @Bean
    public TransactionRepository transactionRepository(){
       return new TransactionRepository();
    }


}
