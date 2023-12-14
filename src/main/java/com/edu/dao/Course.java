package com.edu.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="course_tables")
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private int courseid;
	@NotBlank(message = "Please Enter Course Name")
private String coursename;
	
private int coursefees;
public Course() {
	super();
	// TODO Auto-generated constructor stub
}


@JsonIgnore
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "Studid",referencedColumnName = "Studid")
Student stud;


public Student getStud() {
	return stud;
}
public void setStud(Student stud) {
	this.stud = stud;
}
public Course(int courseid, String coursename, int coursefees) {
	super();
	this.courseid = courseid;
	this.coursename = coursename;
	this.coursefees = coursefees;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public int getCoursefees() {
	return coursefees;
}
public void setCoursefees(int coursefees) {
	this.coursefees = coursefees;
}
@Override
public String toString() {
	return "Course [courseid=" + courseid + ", coursename=" + coursename + ", coursefees=" + coursefees + "]";
}
public void courseAssignStudent(Student sob) 
{
	// TODO Auto-generated method stub
 this.stud=sob;	
}



}
