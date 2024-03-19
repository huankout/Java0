package com.example.demo.Service;


import com.example.demo.Entity.Customer;
import com.example.demo.Exception.CustomerNotFoundException;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {

        this.repository = repository;
    }
    public List<Customer> all(){
        return repository.findAll();
    }
    public Customer save( Customer newCustomer){
        return repository.save(newCustomer);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public Customer findById(long id){

        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
    public Optional<Customer> update(long id,  Customer newCustomer){
        return repository.findById(id).map(customer -> {
            customer.setEmail(newCustomer.getEmail());
            customer.setName(newCustomer.getName());
            repository.save(customer);
            return customer;
        });
    }
}
