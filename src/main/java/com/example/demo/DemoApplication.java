package com.example.demo;

import io.github.superfive666.duosdk.annotation.EnableAnnotatedDuoSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAnnotatedDuoSecurity
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
