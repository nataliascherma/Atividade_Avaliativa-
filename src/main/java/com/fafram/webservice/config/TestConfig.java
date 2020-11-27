package com.fafram.webservice.config;


import com.fafram.webservice.Customer;
import com.fafram.webservice.repositories.CustomerRepository;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // indica ao spring que é uma classe de configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // injeção de dependência
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    // database seeding
    @Override
    public void run(String... args) throws Exception {

        Customer cust1 = new Customer(1,"João", "joao@gmail.com", "91234-5678", "132.658.699-7");
        Customer cust2 = new Customer(2, "Maria", "maria@gmail.com", "91999-7789", "055.646.898-9");


        customerRepository.saveAll(Arrays.asList(cust1, cust2));
    }
}
