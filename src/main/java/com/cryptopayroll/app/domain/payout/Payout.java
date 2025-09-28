package com.cryptopayroll.app.domain.payout;

import com.cryptopayroll.app.domain.employee.Employee;
import com.cryptopayroll.app.domain.payroll.PayrollRun;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payouts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK to payroll_runs(id)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_run_id", nullable = false)
    private PayrollRun payrollRun;

    // FK to employees(id)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Token amount (e.g., USDC with 6 decimals, ETH with 18)
    @Column(name = "amount_token", nullable = false, precision = 36, scale = 18)
    private BigDecimal amountToken;

    // Blockchain tx hash (nullable until sent)
    @Column(name = "tx_hash", length = 100)
    private String txHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    @Builder.Default
    private PayoutStatus status = PayoutStatus.READY;
}
