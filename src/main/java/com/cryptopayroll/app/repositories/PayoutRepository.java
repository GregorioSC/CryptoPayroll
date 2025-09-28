package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.employee.Employee;
import com.cryptopayroll.app.domain.payout.Payout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutRepository extends JpaRepository<Payout,Long> {
}
