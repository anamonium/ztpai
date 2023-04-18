package com.project.marimay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarimayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarimayApplication.class, args);
	}

}
