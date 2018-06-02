package com.goyal.hiberDemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goyal.hiberDemo.entity.Course;
import com.goyal.hiberDemo.entity.Instructor;
import com.goyal.hiberDemo.entity.InstructorDetail;
import com.goyal.hiberDemo.entity.Review;
import com.goyal.hiberDemo.entity.Student;
import com.goyal.hiberDemo.repository.CourseRepository;
import com.goyal.hiberDemo.repository.InstructorDetailRepository;
import com.goyal.hiberDemo.repository.InstructorRepository;
import com.goyal.hiberDemo.repository.StudentRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;

	@Autowired
	private InstructorDetailRepository instructorDetailRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public void createInstructor() {
		Instructor instructor = new Instructor("Kushal", "Goyal", "test@test.com");
		InstructorDetail instructorDetail = new InstructorDetail("kushal", "cubing");

		instructor.setInstructorDetail(instructorDetail);

		instructorRepository.save(instructor);
		System.out.println(instructor);
	}

	public void deleteInstructor() {
		Optional<Instructor> instructor = instructorRepository.findById(4);
		instructorRepository.delete(instructor.get());
	}

	public void getDetails() {
		Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(5);
		System.out.println(instructorDetail.get());
		System.out.println(instructorDetail.get().getInstructor());
	}

	@Transactional
	public void addCourse() {
		Optional<Instructor> instructor = instructorRepository.findById(1);
		Course course = new Course("Java Spring");
		Course course2 = new Course("Angular");
		if (instructor.isPresent()) {
			instructor.get().add(course);
			instructor.get().add(course2);
			instructorRepository.save(instructor.get());
		}

		System.out.println(instructor);
	}

	@Transactional
	public void getInstructorCourses() {
		Optional<Instructor> instructor = instructorRepository.findById(1);
		System.out.println(instructor.get().getCourses());
	}

	public void deleteCourse() {
		Optional<Course> course = courseRepository.findById(3);
		courseRepository.delete(course.get());
	}

	@Transactional
	public void eagerLazyDemo() {
		Optional<Instructor> instructor = instructorRepository.findById(1);
		System.out.println("MYOUTPUT: " + instructor.get());
		System.out.println("MYOUTPUT: " + instructor.get().getCourses());
	}

	@Transactional
	public void createReviews() {
		Optional<Course> course = courseRepository.findById(4);
		course.get().addReview(new Review("Nice course"));
		course.get().addReview(new Review("okayish course"));
		System.out.println(course.get());
		System.out.println(course.get().getReviews());
		courseRepository.save(course.get());
	}

	@Transactional
	public void addStudentsToCourse() {
		Optional<Course> course = courseRepository.findById(4);
		Student student1 = new Student("Ayush", "Goyal", "test@test.com");
		Student student2 = new Student("Kushal", "Goyal", "test@test.com");

		course.get().addStudent(student1);
		course.get().addStudent(student2);

		courseRepository.save(course.get());
	}

	@Transactional
	public void addCoursesToStudent() {
		Optional<Student> student = studentRepository.findById(7);
		Course course1 = new Course("Java Spring");
		Course course2 = new Course("NodeJS");

		course1.addStudent(student.get());
		course2.addStudent(student.get());
		courseRepository.save(course1);
		courseRepository.save(course2);
	}

	@Transactional
	public void getCoursesForStudent() {
		Optional<Student> student = studentRepository.findById(7);
		System.out.println("MYOUTPUT: " + student.get());
		System.out.println("MYOUTPUT: " + student.get().getCourses());
	}
}
