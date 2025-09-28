package com.cryptopayroll.app;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cryptopayroll.app.domain")
public class CryptopayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptopayrollApplication.class, args);
	}

}
