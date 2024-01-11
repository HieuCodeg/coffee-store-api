package com.hieucodeg;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CoffeeStoreApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeStoreApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CoffeeStoreApiApplication.class, args);
		logger.info("Java Coffee Application Started........");
	}

}
