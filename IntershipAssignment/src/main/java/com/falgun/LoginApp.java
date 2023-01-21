package com.falgun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LoginApp {

	public static void main(String[] args) {
		SpringApplication.run(LoginApp.class, args);
	}

}
