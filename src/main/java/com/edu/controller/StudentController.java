package com.edu.controller;

import java.rmi.StubNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Student;
import com.edu.error.StudentNotFoundException;
import com.edu.service.StudentService;

@RestController
public class StudentController 
{
    @Autowired
    private StudentService studentService;
    
//    @PostMapping("/saveStudent")
//    public Student saveStudent(@RequestBody Student student)
//    {
//		return studentService.saveStudent(student);
//    	
//    }
    @PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
		Student stud=studentService.saveStudent(student);
		
		return new ResponseEntity<Student>(stud,HttpStatus.CREATED);	
	}
   
    @GetMapping("/findAllStudent")
    public List<Student> findAllStudent()
    {
		return studentService.findAllStudent();
    	
    }
    
    @GetMapping("/getStudentById/{sid}")
    public Student getStudentById(@PathVariable("sid") Integer studentid) throws StudentNotFoundException
    {
		return studentService.getStudentById(studentid);
    	
    }
    
    
	 @DeleteMapping("/deleteStudentById/{sid}")
	 public String deleteStudentById(@PathVariable("sid") Integer studentid) throws StudentNotFoundException 
	 {
		 
		 studentService.deleteStudentById(studentid);
		 return "Student deleted Succesfully";
	 }
	
}

