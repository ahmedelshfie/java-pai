package com.api.io.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	public String NOME = "Rafel";

	@BeforeEach
	void initial() {
		NOME = "ROSE";
	}

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	public void getName() {
		if (NOME.equals("ROSE")) {
			NOME = "ROSE";
		} else {
			NOME = "RAFAEL";
		}
	}

}
