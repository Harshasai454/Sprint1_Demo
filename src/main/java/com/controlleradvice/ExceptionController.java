package com.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.controllerexp.AdminNotFoundException;
import com.controllerexp.DeliveryNotFoundException;
import com.controllerexp.RepairNotFoundException;
import com.controllerexp.TrackingNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	 @ExceptionHandler(value = TrackingNotFoundException.class)
	   public ResponseEntity<Object> exception(TrackingNotFoundException exception) {
	      return new ResponseEntity<>("Tracking Id is not found or Details Yet to update !", HttpStatus.NOT_FOUND);
	   }
	 
	 @ExceptionHandler(value = AdminNotFoundException.class)
	   public ResponseEntity<Object> exception(AdminNotFoundException exception) {
	      return new ResponseEntity<>("Admin Not Found!", HttpStatus.NOT_FOUND);
	   }
	 
	 @ExceptionHandler(value = DeliveryNotFoundException.class)
	   public ResponseEntity<Object> exception(DeliveryNotFoundException exception) {
	      return new ResponseEntity<>("Delivery Person Id is not valid or Details Yet to update !", HttpStatus.NOT_FOUND);
	   }
	 
	 @ExceptionHandler(value = RepairNotFoundException.class)
	   public ResponseEntity<Object> exception(RepairNotFoundException exception) {
	      return new ResponseEntity<>("Repair Details Id is not valid or Details Yet to update !", HttpStatus.NOT_FOUND);
	   }

}
