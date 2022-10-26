package com.controllerexp;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(final String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
}
