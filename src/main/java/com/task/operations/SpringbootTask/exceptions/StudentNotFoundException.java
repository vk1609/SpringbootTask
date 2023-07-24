package com.task.operations.SpringbootTask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
	
	private Long fieldValue;
	private String feildFirstName;
	private String feildLatName;
	
	public StudentNotFoundException(Long fieldValue, String feildFirstName, String feildLatName) {
		super(String.format("Student not found"));
		this.fieldValue = fieldValue;
		this.feildFirstName = feildFirstName;
		this.feildLatName = feildLatName;
	}
	
	

}
