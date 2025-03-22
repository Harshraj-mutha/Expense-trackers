package com.app.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//handle the field error from DTO. (i.e.error messages when @valid fails)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> HandleMethodArgumentValidException( MethodArgumentNotValidException exception){
		Map<String, String>	fieldErrors = new HashMap<>();
		List<ObjectError> errors =exception.getBindingResult().getAllErrors();
			for(ObjectError fe : errors){
				fieldErrors.put(((FieldError) fe).getField(), fe.getDefaultMessage());
			}
			return new ResponseEntity<>(fieldErrors,HttpStatus.BAD_REQUEST);
	}
	
	//handle custom exception for unavailable user
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundExcption(UserNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
