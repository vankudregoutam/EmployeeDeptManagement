package com.example.demo.exception;

public class DeptAlreadyExists extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Department already exists";
	}

}
