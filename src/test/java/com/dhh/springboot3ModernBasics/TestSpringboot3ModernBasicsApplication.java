package com.dhh.springboot3ModernBasics;

import org.springframework.boot.SpringApplication;

public class TestSpringboot3ModernBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.from(Springboot3ModernBasicsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
