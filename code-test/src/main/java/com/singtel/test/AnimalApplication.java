package com.singtel.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ashis
 * 
 * Springboot main application
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class AnimalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}
	
}
