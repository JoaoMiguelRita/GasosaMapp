package com.example.gasosamapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class GasosamappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasosamappApplication.class, args);
	}

}
