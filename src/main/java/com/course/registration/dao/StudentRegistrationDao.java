package com.course.registration.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.registration.entities.Student;
import com.course.registration.repos.CourseRepo;
import com.course.registration.repos.StudentRepo;

@Service
public class StudentRegistrationDao {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private CourseRepo courseRepo;
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepo.findAll().forEach(students::add);
		return students;
	}
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public void deleteStudentByName(String studentName) {
		studentRepo.deleteByName(studentName);
	}
	
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
	}
	
	public Set<String> getStudentsByCourse(String courseName) {
		Set<String> students = new TreeSet<>();
		courseRepo.findByName(courseName).forEach(course -> {
			Set<Student> studentsObjSet = course.getStudents();
			studentsObjSet.forEach(stObj -> students.add(stObj.getName()));
		});
		return students;
	}
}
