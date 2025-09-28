package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.employee.Employee;
import com.cryptopayroll.app.domain.payroll.PayrollRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PayrollRunRepository extends JpaRepository<PayrollRun, Long> {
}
