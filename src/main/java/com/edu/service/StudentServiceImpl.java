package com.edu.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.StudentNotFoundException;
import com.edu.repository.CourseRepository;
import com.edu.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentById(Integer studentid) throws StudentNotFoundException {
		Optional<Student> stud=studentRepository.findById(studentid);
		if(stud.isPresent())
		{
		return studentRepository.findById(studentid).get();
		}
		else
		{
			throw new StudentNotFoundException(studentid+" is not Present");
		}
	}
	@Override
	public void deleteStudentById(Integer studentid) throws  StudentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> stud=studentRepository.findById(studentid);
		if(stud.isPresent())
		{
		    studentRepository.deleteById(studentid);
		}
		else
		{
			throw new StudentNotFoundException(studentid+" Not Present");
		}
	}
	

}
