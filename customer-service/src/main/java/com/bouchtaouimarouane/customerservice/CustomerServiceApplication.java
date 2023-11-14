package com.bouchtaouimarouane.customerservice;

import com.bouchtaouimarouane.customerservice.entities.Customer;
import com.bouchtaouimarouane.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Marouane").email("maro@gmail.com").build(),
                    Customer.builder().name("Bouchtaoui").email("bcht@gmail.com").build(),
                    Customer.builder().name("Oussama").email("oussama@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
