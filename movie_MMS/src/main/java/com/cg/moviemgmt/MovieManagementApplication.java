package com.cg.moviemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * this is equal to three annotations
 * 1) @Configuration
 * 2)@ComponentScan
 * 3)@EnableAutoConfiguration
 */
@SpringBootApplication
@EnableTransactionManagement
public class MovieManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieManagementApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	

	}

