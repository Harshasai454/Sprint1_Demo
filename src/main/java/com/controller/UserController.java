package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.Address1Dao;
import com.dao.DeliveryPerson1Dao;
import com.dao.Device1Dao;
import com.dao.Employee1Dao;
import com.dao.Tracking1Dao;
import com.model.Address1;
import com.model.Authenticate2;
import com.model.DeliveryPerson1;
import com.model.Device1;
import com.model.Employee1;
import com.model.Tracking1;



@RestController
public class UserController {
	
	@Autowired
	Employee1Dao edao;
	
	@Autowired
	Device1Dao ddao;
	
	@Autowired
	Tracking1Dao tdao;
	
	@Autowired
	DeliveryPerson1Dao dpdao;
	
	@Autowired
	Address1Dao adao;
	
	@PostMapping("/addemployee")
	 public ResponseEntity<?> addUser(@RequestBody Employee1 employee)
   {
       edao.save(employee);
       return new ResponseEntity<>("Employee added successfully",HttpStatus.OK);

   }
	@PostMapping("/adddevice")
	public ResponseEntity<?> addDevice(@RequestBody Authenticate2 authenticate) {
		
		String username = authenticate.getEmployee().getUserName();
		String password = authenticate.getEmployee().getPassword();
		
		Employee1 employeeexist = edao.findByUserName(username);
		if(employeeexist.getUserName().equals(username)&&employeeexist.getPassword().equals(password)) {
			Device1 device = authenticate.getDevice();
			ddao.save(device);
			return ResponseEntity.ok("Data Saved");
		}
		else {
		 return ResponseEntity.ok("Employee not Found");
		}
	}
	
	@GetMapping("/getdeliveryperson/{id}")
	public Optional<DeliveryPerson1> getdetails(@PathVariable int id) {
		return  dpdao.findById(id);
	}
	@GetMapping("/gettrackingdetails/{id}")
	public Optional<Tracking1> gettrackingdetails(@PathVariable int id) {
		return  tdao.findById(id);
	}
	
	/*@PostMapping("/addaddress")
	 public ResponseEntity<?> addaddress(@RequestBody Address1 address)
  {
      adao.save(address);
      return new ResponseEntity<>("Employee added successfully",HttpStatus.OK);

  }*/
	@GetMapping("/getdevice")
	public List<Device1> getdevice() {
		return  ddao.findAll();
	}

}


