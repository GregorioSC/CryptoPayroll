package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
