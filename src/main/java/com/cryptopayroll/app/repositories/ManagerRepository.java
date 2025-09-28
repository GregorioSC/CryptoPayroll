package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.company.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
