package com.barak.websiteservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.barak")
public class WebsiteServiceApplication {

	private static final Logger LOG = LoggerFactory.getLogger(WebsiteServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebsiteServiceApplication.class, args);
	}

}
