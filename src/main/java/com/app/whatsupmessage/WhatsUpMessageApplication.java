package com.app.whatsupmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsUpMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsUpMessageApplication.class, args);
		System.out.println("hello CI/CD");
	}

}
