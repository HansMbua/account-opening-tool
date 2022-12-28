package com.love2code.accountopeningtool.Repository;
import com.love2code.accountopeningtool.Model.Customer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryCustomerRepository implements CustomerRepository   {

    private  List<Customer> customers;
    public InMemoryCustomerRepository() {

        this.customers = new ArrayList<>(Arrays.asList(

        ));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Optional<Customer> findById(Long id) {

        return customers.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public void deleteById(String id) {
        customers.removeIf(c -> c.getCustomerId().equals(id));
    }



}
