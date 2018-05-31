package com.goyal.hiberDemo;

import com.goyal.hiberDemo.entity.Student;
import com.goyal.hiberDemo.repository.StudentRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(HiberDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 Student student1 = new Student("Kushal", "Goyal", "test@test.com");
//		 Student student2 = new Student("Palash", "Goyal", "test@test.com");
//		 Student student3 = new Student("Arpit", "Goyal", "test@test.com");
//		 studentRepository.save(student1);
//		 studentRepository.save(student2);
//		 studentRepository.save(student3);

		Optional<Student> student = studentRepository.findById(1);
		studentRepository.delete(student.get());
		System.out.println(student);
	}
}
