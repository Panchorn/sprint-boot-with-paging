package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PagingRepository {

    public List<Customer> getData() {
        return assumeFromDatabase();
    }

    private List<Customer> assumeFromDatabase() {
        Customer customer0 = new Customer(0L, "John", "j", 25);
        Customer customer1 = new Customer(1L, "Chris", "c", 27);
        Customer customer2 = new Customer(2L, "Smith", "s", 21);
        Customer customer3 = new Customer(3L, "", "j", 23);
        List<Customer> response = Arrays.asList(customer0, customer1, customer2, customer3);
        return response;
    }

}
