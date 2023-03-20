package com.oobj.obs.name;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NameGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameGeneratorServiceApplication.class, args);
	}

}
