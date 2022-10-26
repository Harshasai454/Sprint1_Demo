package com.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.controllerexp.AdminNotFoundException;
import com.controllerexp.AdminOrDeviceNotFoundException;
import com.controllerexp.EmployeeNotFoundException;

@ControllerAdvice
public class AdminExceptionController {
	
	
	 
	 @ExceptionHandler(value = AdminNotFoundException.class)
	   public ResponseEntity<Object> exception(AdminNotFoundException exception) {
	      return new ResponseEntity<>("Admin Not Found!", HttpStatus.NOT_FOUND);
	   }
	 
	 @ExceptionHandler(value= EmployeeNotFoundException.class)
	 	public ResponseEntity<Object> exception(EmployeeNotFoundException exception){
		 return new ResponseEntity<>("Employee Not Found!", HttpStatus.NOT_FOUND);
	 }
	 

	 @ExceptionHandler(value= AdminOrDeviceNotFoundException.class)
	 	public ResponseEntity<Object> exception(AdminOrDeviceNotFoundException exception){
		 return new ResponseEntity<>("Please Check Admin details or Device Details!", HttpStatus.NOT_FOUND);
	 }
	 

}
