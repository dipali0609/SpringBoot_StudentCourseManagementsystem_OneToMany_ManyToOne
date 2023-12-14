package com.edu.service;

import java.rmi.StubNotFoundException;
import java.util.List;

import com.edu.dao.Student;
import com.edu.error.StudentNotFoundException;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> findAllStudent();

	public Student getStudentById(Integer studentid) throws StudentNotFoundException;
    
	public void deleteStudentById(Integer studentid) throws StudentNotFoundException;

	

}
