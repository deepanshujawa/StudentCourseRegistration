package com.course.registration.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "registered_students", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	Set<Course> coursesTaken;

	public Student() {

	}

	public Student(Integer id, String name, Set<Course> coursesTaken) {
		super();
		this.id = id;
		this.name = name;
		this.coursesTaken = coursesTaken;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(Set<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	

}
