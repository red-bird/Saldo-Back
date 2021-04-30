package com.redbird.SaldoBack;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * Main class where SpringBoot App start
 */
@SpringBootApplication
@OpenAPIDefinition
public class SaldoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaldoBackApplication.class, args);
	}

	@Value("${spring.jpa.hibernate.jdbc.time_zone}")
	private String timezone;

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(timezone));
	}
}
