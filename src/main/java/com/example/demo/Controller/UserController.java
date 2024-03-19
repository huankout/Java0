package com.example.demo.Controller;


import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class UserController {
    private final CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("customers")
    public List<Customer> findAll(){
        return customerService.all();
    }
    @PostMapping("customers")
    public Customer save(@RequestBody Customer newCustomer){
        return customerService.save(newCustomer);
    }
    @DeleteMapping("customers/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }
    @GetMapping("customers/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }
    @PutMapping("/customers/{id}")
    public Optional<Customer> create(@PathVariable Long id, @RequestBody Customer newCustomer){
        return customerService.update(id, newCustomer);
    }
}
