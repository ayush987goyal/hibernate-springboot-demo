package com.goyal.hiberDemo;

import com.goyal.hiberDemo.entity.Student;
import com.goyal.hiberDemo.repository.StudentRepository;
import com.goyal.hiberDemo.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HiberDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private InstructorService instructorService;

	public static void main(String[] args) {
		SpringApplication.run(HiberDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Student> student = studentRepository.findById(1);
		System.out.println(student);
		
		instructorService.getDetails();
	}
}
