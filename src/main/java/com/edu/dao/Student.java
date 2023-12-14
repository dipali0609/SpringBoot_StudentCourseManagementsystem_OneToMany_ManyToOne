package com.edu.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name="student_tables")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Studid")
 private int studentid;
	@Column(length=50)
	@NotBlank(message = "Please Enter Student Name")
 private String studentname;
	@Column(length = 10)	
 private long studentmobile;
	@Min(value = 18,message = "Student age not less than 18")
	@Max(value=30, message = "Student age not greter than 30")
 private int studentage;
	@Column(length=50)
	@NotBlank(message = "Please Enter Student location")
 private String studentlocation;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "stud")
	Set<Course> course=new HashSet<Course>();
	
//	
//	"studentname":"Dipali",
//	   "studentmobile":1234567890,
//	   "studentage":22,
//	   "studentlocation":"Pune"
//	
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	public Student(int studentid, String studentname, long studentmobile, int studentage, String studentlocation) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
		this.studentage = studentage;
		this.studentlocation = studentlocation;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(long studentmobile) {
		this.studentmobile = studentmobile;
	}
	public int getStudentage() {
		return studentage;
	}
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}
	public String getStudentlocation() {
		return studentlocation;
	}
	public void setStudentlocation(String studentlocation) {
		this.studentlocation = studentlocation;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentmobile=" + studentmobile
				+ ", studentage=" + studentage + ", studentlocation=" + studentlocation + "]";
	}
	
 
 
}
