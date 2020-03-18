package com.br.finances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancesApplication.class, args);
	}

}
