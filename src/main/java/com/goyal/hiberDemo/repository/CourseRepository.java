package com.goyal.hiberDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goyal.hiberDemo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
