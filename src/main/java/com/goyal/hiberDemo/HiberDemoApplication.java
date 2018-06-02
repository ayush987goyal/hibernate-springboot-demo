package com.goyal.hiberDemo;

import com.goyal.hiberDemo.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiberDemoApplication implements CommandLineRunner {
	
	@Autowired
	private InstructorService instructorService;

	public static void main(String[] args) {
		SpringApplication.run(HiberDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		instructorService.eagerLazyDemo();
	}
}
