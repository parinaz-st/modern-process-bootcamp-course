package com.tetra.bank.web.rest;

import com.tetra.bank.domain.Employee;
import com.tetra.bank.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResource {

     private final EmployeeRepository employeeRepository;

     // Constructor based DI
    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
        // test git
    @GetMapping("/employees")
    public List<Employee> all()
    {
        return employeeRepository.findAll();
    }
    @PostMapping("/employees")
   public Employee newEmployee(@RequestBody Employee newEmployee)
    {
        return employeeRepository.save(newEmployee);
    }

}
