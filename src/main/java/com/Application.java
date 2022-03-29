/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com;

import com.dto.Ville;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Application Start !");
	}
}
