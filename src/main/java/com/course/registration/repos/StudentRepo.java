package com.course.registration.repos;

import org.springframework.data.repository.CrudRepository;

import com.course.registration.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	public void deleteById(Integer id);
	public long deleteByName(String name);
}
