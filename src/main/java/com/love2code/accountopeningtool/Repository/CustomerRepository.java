package com.love2code.accountopeningtool.Repository;

import com.love2code.accountopeningtool.Model.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@ComponentScan
@Repository
public interface CustomerRepository {

    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void deleteById(String id);


}
