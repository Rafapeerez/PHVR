package com.english.phvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PhvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhvrApplication.class, args);
	}

}
