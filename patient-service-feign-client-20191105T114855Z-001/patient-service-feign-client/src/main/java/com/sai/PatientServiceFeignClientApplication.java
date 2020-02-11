package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.sai.clients")
public class PatientServiceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceFeignClientApplication.class, args);
	}

}
