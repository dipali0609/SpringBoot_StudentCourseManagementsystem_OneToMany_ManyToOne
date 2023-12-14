package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.CourseNotFoundException;
import com.edu.service.CourseService;

@RestController
public class CourseController 
{
	@Autowired
   private CourseService courseService;
	
//	@PostMapping("/saveCourse")
//	public Course saveCourse(@RequestBody Course course)
//	{
//		return courseService.saveCourse(course);	
//	}
	
	
	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course){
		Course cou=courseService.saveCourse(course);
		
		return new ResponseEntity<Course>(cou,HttpStatus.CREATED);	
	}
	
	 @PutMapping("/courseAssignStudent/{cid}/student/{sid}")
	    public Course courseAssignStudent(@PathVariable("cid") Integer courseid, @PathVariable("sid") Integer studentid )
	    {
			return courseService.courseAssignStudent(courseid, studentid);
	    	
	    }
	@GetMapping("/findAllCourse")
	public List<Course> findAllCourse()
	{
		return courseService.findAllCourse();
		
	}
	
	
	 @GetMapping("/getCourseById/{cid}")
	    public Course getCourseById(@PathVariable("cid") Integer courseid) throws CourseNotFoundException
	    {
			return courseService.getCourseById(courseid);
	    	
	    }
	 
	 @DeleteMapping("/deleteCourseById/{cid}")
	 public String deleteCourseById(@PathVariable("cid") Integer courseid) throws CourseNotFoundException 
	 {
		 courseService.deleteCourseById(courseid);
		 return "Course deleted Succesfully";
	 }
	
	
	
	
}
