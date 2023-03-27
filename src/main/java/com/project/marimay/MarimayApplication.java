package com.project.marimay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class MarimayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarimayApplication.class, args);
	}

	@RequestMapping("/welcomePage")
	public String login(){
		return "welcomePage";
	}

}
