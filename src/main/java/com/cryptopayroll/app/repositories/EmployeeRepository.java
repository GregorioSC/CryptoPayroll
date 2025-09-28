package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.employee.Employee;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    // Java
    Employee findByFirstName(String firstName);

}
