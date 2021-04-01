package com.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SuppressWarnings("unused")
@SpringBootApplication
public class FiboApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiboApplication.class, args);
	}

}
