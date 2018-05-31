package com.goyal.hiberDemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyal.hiberDemo.entity.Instructor;
import com.goyal.hiberDemo.entity.InstructorDetail;
import com.goyal.hiberDemo.repository.InstructorDetailRepository;
import com.goyal.hiberDemo.repository.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	
	public void createInstructor() {
		Instructor instructor = new Instructor("Kushal", "Goyal", "test@test.com");
		InstructorDetail instructorDetail = new InstructorDetail("kushal", "cubing");
		
		instructor.setInstructorDetail(instructorDetail);
		
		instructorRepository.save(instructor);
		System.out.println(instructor);
	}
	
	public void deleteInstructor() {
		Optional<Instructor> instructor = instructorRepository.findById(6);
		instructorRepository.delete(instructor.get());
	}
	
	public void getDetails() {
		Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(5);
		System.out.println(instructorDetail.get());
		System.out.println(instructorDetail.get().getInstructor());
	}
}
