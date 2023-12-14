package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>
{

}
