package com.cryptopayroll.app.domain.employee;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "wallet_addr", nullable = false, length = 64)
    private String walletAddr;

    @Column(name = "salary_usd", nullable = false, precision = 12, scale = 2)
    private BigDecimal salaryUsd;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}
