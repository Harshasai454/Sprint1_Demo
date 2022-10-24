package com.controllerexp;

public class DeliveryNotFoundException extends RuntimeException{
	
	public DeliveryNotFoundException() {
		super();
	}
	
	public DeliveryNotFoundException(final String message) {
		super(message);
	}
	
	private static final long serialVersionUID = 1L;

}
