package com.ufrn.imd.planob.planobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ufrn.imd.planob.planobapi.repository"})
public class PlanobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanobApiApplication.class, args);
	}

}
