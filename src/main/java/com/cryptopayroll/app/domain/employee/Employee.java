package com.cryptopayroll.app.domain.employee;

import com.cryptopayroll.app.domain.company.Company;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "wallet_addr", nullable = false, length = 64)
    private String walletAddr;

    @Column(name = "salary_usd", nullable = false, precision = 12, scale = 2)
    private BigDecimal salaryUsd;

    @Column(name = "is_active", nullable = false)

    private boolean active = true;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;


    public Employee(String email, String firstName, String lastName, String walletAddr, BigDecimal salaryUsd) {
        this.email = email;
        this.firstName = firstName;
        this.walletAddr = walletAddr;
        this.salaryUsd = salaryUsd;
        this.lastName = lastName;

    }



    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWalletAddr() {
        return walletAddr;
    }

    public void setWalletAddr(String walletAddr) {
        this.walletAddr = walletAddr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalaryUsd() {
        return salaryUsd;
    }

    public void setSalaryUsd(BigDecimal salaryUsd) {
        this.salaryUsd = salaryUsd;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
