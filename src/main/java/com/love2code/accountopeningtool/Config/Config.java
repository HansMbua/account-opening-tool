package com.love2code.accountopeningtool.Config;

import com.love2code.accountopeningtool.Repository.CustomerRepository;
import com.love2code.accountopeningtool.Repository.InMemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

   @Bean
    public CustomerRepository customerRepository() {
        return new InMemoryCustomerRepository();
    }
}
