package com.example.demo.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id){
        super(String.format("Customer with id %s not found",id));
    }
}
