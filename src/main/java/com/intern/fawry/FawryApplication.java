package com.intern.fawry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.intern.fawry.repository")

public class FawryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FawryApplication.class, args);
	}

}
 