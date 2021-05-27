package com.course.registration.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.registration.dao.StudentRegistrationDao;
import com.course.registration.entities.Student;

@RestController
public class RegistrationController {
	
	@Autowired
	StudentRegistrationDao studentRegDao;
	
	@PostMapping(path = "/registerStudent")
	public String addStudent(@RequestBody Student student) {
		studentRegDao.addStudent(student);
		return "Student Registered";
	}

	@GetMapping("/getStudent/{courseName}")
	public Set<String> getStudents(@PathVariable String courseName) {
		return studentRegDao.getStudentsByCourse(courseName);
	}
	
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@PathVariable String studentName) {
		studentRegDao.deleteStudentByName(studentName);
		return "Student Record deleted.";
	}
	
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@PathVariable Integer id) {
		studentRegDao.deleteStudentById(id);
		return "Student Record deleted.";
	}
}
