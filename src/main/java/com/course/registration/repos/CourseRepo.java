package com.course.registration.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.course.registration.entities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {

	public List<Course> findByName(String name);
}
