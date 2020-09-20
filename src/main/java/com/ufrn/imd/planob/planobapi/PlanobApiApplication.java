package com.ufrn.imd.planob.planobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ufrn.imd.planob.planobapi.model")
@EnableJpaRepositories("com.ufrn.imd.planob.planobapi.repository")
public class PlanobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanobApiApplication.class, args);
	}

}
