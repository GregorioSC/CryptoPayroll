package com.cryptopayroll.app.repositories;

import com.cryptopayroll.app.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
