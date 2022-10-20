package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.*;
import com.model.*;

import io.swagger.annotations.ApiResponse;
@RestController
public class HomeController {
	
	@Autowired
	Employee1Dao edao;
	
	@Autowired
	Address1Dao adao;
	
	@PostMapping("/addaddress")
	public ResponseEntity<String> addAddress(@RequestBody Employee1 employee) {
		
		//Address a = employee.getAddress();
		//a.setEmployee(employee);
		edao.save(employee);
		return ResponseEntity.ok("Data Saved");
		//return new ResponseEntity("Address added" , HttpStatus.OK);
	}
	@ApiResponse(code= 200, message= "Customer Sucessfully dispalyed")
	@GetMapping("/getallcustomer")
	public List<Employee1> getAllItem(){
		
		return edao.findAll();
	}
	/*@ApiResponse(code= 200, message= "Customer Sucessfully dispalyed")
	@GetMapping("/getalladdress")
	public List<Address1> getAllAddress(){
		
		return adao.findAll();*/
	
}
	
