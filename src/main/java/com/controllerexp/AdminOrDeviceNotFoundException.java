package com.controllerexp;

public class AdminOrDeviceNotFoundException extends RuntimeException {
	
	public AdminOrDeviceNotFoundException() {
		super();
	}

	public AdminOrDeviceNotFoundException(final String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
}
