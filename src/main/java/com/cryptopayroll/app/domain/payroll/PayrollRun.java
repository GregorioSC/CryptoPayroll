package com.cryptopayroll.app.domain.payroll;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payroll_runs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PayrollRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "period_start", nullable = false)
    private LocalDate periodStart;

    @Column(name = "period_end", nullable = false)
    private LocalDate periodEnd;

    // USD -> token rate snapshot used for this run
    @Column(name = "fx_rate_usd_to_token", nullable = false, precision = 18, scale = 8)
    private BigDecimal fxRateUsdToToken;

    // e.g., "sepolia", "mainnet"
    @Column(nullable = false, length = 32)
    private String network;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    @Builder.Default
    private PayrollStatus status = PayrollStatus.DRAFT;
}
