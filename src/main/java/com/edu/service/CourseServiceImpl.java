package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.CourseNotFoundException;
import com.edu.repository.CourseRepository;
import com.edu.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
	private CourseRepository courseRepository;
    
    @Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course courseAssignStudent(Integer courseid, Integer studentid) {
		// TODO Auto-generated method stub
		Course cob=courseRepository.findById(courseid).get();
		Student sob=studentRepository.findById(studentid).get();
		cob.courseAssignStudent(sob);
		return courseRepository.save(cob);
		
	}

	@Override
	public Course getCourseById(Integer courseid) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		Optional<Course> c=courseRepository.findById(courseid);
		if(c.isPresent())
		{
			return courseRepository.findById(courseid).get();
		}
		else
		{
			throw new CourseNotFoundException(courseid+" Is not Present");
		}
		
	}

	@Override
	public void deleteCourseById(Integer courseid) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		Optional<Course> c=courseRepository.findById(courseid);
		if(c.isPresent())
		{
		courseRepository.deleteById(courseid);
		}
		else
		{
			throw new CourseNotFoundException(courseid+" Is not Present");
		}
	}
	
	

}

