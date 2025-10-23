package com.sorteasy.sorteasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SorteasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorteasyApplication.class, args);
	}

}
