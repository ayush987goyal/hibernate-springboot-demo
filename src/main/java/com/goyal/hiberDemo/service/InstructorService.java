package com.goyal.hiberDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyal.hiberDemo.entity.Instructor;
import com.goyal.hiberDemo.entity.InstructorDetail;
import com.goyal.hiberDemo.repository.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	public void createInstructor() {
		Instructor instructor = new Instructor("Ayush", "Goyal", "test@test.com");
		InstructorDetail instructorDetail = new InstructorDetail("ayush", "cubing");
		
		instructor.setInstructorDetail(instructorDetail);
		
		instructorRepository.save(instructor);
		System.out.println(instructor);
	}
}
