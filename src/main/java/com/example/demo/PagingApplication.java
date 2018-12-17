package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.repository.PagingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PagingApplication {

    private final PagingRepository pagingRepository;

    public PagingApplication(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PagingApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            pagingRepository.saveAll(getData());
            pagingRepository.flush();
        };
    }

    private List<Customer> getData() {
        Customer customer0 = new Customer(0L, "John", "j", 25);
        Customer customer1 = new Customer(1L, "Chris", "c", 27);
        Customer customer2 = new Customer(2L, "Smith", "s", 21);
        Customer customer3 = new Customer(3L, "Dean", "d", 23);
        return Arrays.asList(customer0, customer1, customer2, customer3);
    }

}