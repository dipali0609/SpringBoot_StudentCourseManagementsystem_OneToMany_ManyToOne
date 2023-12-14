package com.edu.service;

import java.util.List;

import com.edu.dao.Course;
import com.edu.error.CourseNotFoundException;


public interface CourseService 
{
	public Course saveCourse(Course course);

	public List<Course> findAllCourse();

	public Course courseAssignStudent(Integer courseid, Integer studentid);

	public Course getCourseById(Integer courseid) throws CourseNotFoundException;

	public void deleteCourseById(Integer courseid) throws CourseNotFoundException;

}
