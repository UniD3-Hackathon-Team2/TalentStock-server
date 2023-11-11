package com.second.talentstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TalentStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentStockApplication.class, args);
	}

}
