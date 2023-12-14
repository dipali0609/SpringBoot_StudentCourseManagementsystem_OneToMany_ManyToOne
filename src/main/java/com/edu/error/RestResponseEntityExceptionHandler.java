package com.edu.error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edu.dao.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ErrorMessage> StudentNotFoundException(StudentNotFoundException exception,WebRequest request) {
	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
   }

@ExceptionHandler(CourseNotFoundException.class)
public ResponseEntity<ErrorMessage> CourseNotFoundException(CourseNotFoundException exception,WebRequest request) {
	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
   }

}