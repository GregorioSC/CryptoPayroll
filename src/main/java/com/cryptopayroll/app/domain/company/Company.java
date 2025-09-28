package com.cryptopayroll.app.domain.company;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, length = 255)
    private String companyName;

    @Column(nullable = false, unique = true, length = 255)
    private String companyEmail;

    @Column(nullable = false, length = 255)
    private String companyPhone;


    public Company() {
    }

    public Company(String companyName, String companyEmail, String companyPhone) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
    }

    public Company(Long companyId, String companyName, String companyPhone, String companyEmail) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }


}
