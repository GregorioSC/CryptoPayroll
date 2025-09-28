package com.cryptopayroll.app.services;

import com.cryptopayroll.app.domain.employee.Employee;
import com.cryptopayroll.app.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class EmployeeServices {

    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository =  employeeRepository;
    }

    public Employee createEmployee(String email, String firstName, String lastName, String walletAddr, BigDecimal salaryUsd){
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email format.");
        if (salaryUsd == null || salaryUsd.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Salary must be positive.");
        Employee employee = new Employee(email, firstName, lastName, walletAddr, salaryUsd);
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        if (id == null || id <= 0)
            throw new IllegalArgumentException("Invalid ID.");
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
    }

    public Employee editEmployee(Long id, String email, String firstName, String lastName, String walletAddr, BigDecimal salaryUsd) {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("Invalid ID.");
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email format.");
        if (salaryUsd == null || salaryUsd.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Salary must be positive.");
        employee.setEmail(email);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setWalletAddr(walletAddr);
        employee.setSalaryUsd(salaryUsd);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        if (id == null || id <= 0)
            throw new IllegalArgumentException("Invalid ID.");
        if (!employeeRepository.existsById(id))
            throw new EntityNotFoundException("Employee not found.");
        employeeRepository.deleteById(id);
    }
}
