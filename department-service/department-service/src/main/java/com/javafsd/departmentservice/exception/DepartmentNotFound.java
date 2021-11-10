package com.javafsd.departmentservice.exception;

public class DepartmentNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public DepartmentNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DepartmentNotFound(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DepartmentNotFound(String message) {
		super(message);
		
	}

	public DepartmentNotFound(Throwable cause) {
		super(cause);
		
	}

}
