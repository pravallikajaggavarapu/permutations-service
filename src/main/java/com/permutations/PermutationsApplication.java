package com.permutations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.permutations.controller","com.permutations.service"})
public class PermutationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermutationsApplication.class, args);
	}

}
