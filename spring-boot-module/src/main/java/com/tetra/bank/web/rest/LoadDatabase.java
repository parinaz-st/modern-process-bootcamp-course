package com.tetra.bank.web.rest;

import com.tetra.bank.domain.Employee;
import com.tetra.bank.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository)
    {

         return args ->
        {
            log.info("Preloading" + repository.save(new Employee("Caribou", "manager")));
            log.info("Preloading" +  repository.save(new Employee("pst", "admin")));
        };
    }
}
