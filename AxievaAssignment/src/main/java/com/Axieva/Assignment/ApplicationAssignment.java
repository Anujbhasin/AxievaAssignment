package com.Axieva.Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.Axieva.Assignment.repository")
@EntityScan("com.Axieva.Assignment.model")
public class ApplicationAssignment{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationAssignment.class, args);
	}

}
