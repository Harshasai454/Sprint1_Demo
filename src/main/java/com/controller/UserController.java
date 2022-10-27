package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.controllerexp.DeliveryNotFoundException;
import com.controllerexp.RepairNotFoundException;
import com.controllerexp.TrackingNotFoundException;
import com.dao.Address1Dao;
import com.dao.DeliveryPerson1Dao;
//import com.dao.Device1Dao;
import com.dao.Employee1Dao;
import com.dao.Repair1Dao;
import com.dao.Tracking1Dao;
//import com.model.Address1;
//import com.model.Authenticate2;
import com.model.DeliveryPerson1;
//import com.model.Device1;
import com.model.Employee1;
import com.model.Repair1;
import com.model.Tracking1;



@RestController
public class UserController {
	
	@Autowired
	Employee1Dao edao;
	
	@Autowired
	Tracking1Dao tdao;
	
	@Autowired
	DeliveryPerson1Dao dpdao;
	
	@Autowired
	Address1Dao adao;
	
	@Autowired
	Repair1Dao rdao;
	
	@PostMapping("/addemployee")
	 public ResponseEntity<?> addUser(@RequestBody Employee1 employee)
   {
       edao.save(employee);
       return new ResponseEntity<>("Employee added successfully",HttpStatus.OK);

   }
	
	@GetMapping("/getdeliveryperson/{id}")
	public DeliveryPerson1 getdetails(@PathVariable int id) throws DeliveryNotFoundException{
		try {
			return  dpdao.findById(id).get();
		}catch(Exception e) {
			throw new DeliveryNotFoundException();
		}
	}
	@GetMapping("/gettrackingdetails/{id}")
	public Tracking1 gettrackingdetails(@PathVariable int id) throws TrackingNotFoundException{
		try {
	
			return  tdao.findById(id).get();
		}catch(Exception e) {
			throw new TrackingNotFoundException();
		}
	}
	
	@GetMapping("/getrepairdetails/{id}")
	public Repair1 getrepair(@PathVariable int id) throws RepairNotFoundException {
		try {
			return  rdao.findById(id).get();
		}catch(Exception e) {
			throw new RepairNotFoundException();
		}
	}
	
	@GetMapping("/gettrackingbyId/{tracking_Id}")
	public ResponseEntity<String> findByPk(@PathVariable("tracking_Id") int tracking_Id) throws TrackingNotFoundException{
		try {
			Tracking1 obj=tdao.findById(tracking_Id).get();
			StringBuilder rtnString=new StringBuilder();
			rtnString.append("Status is: "+obj.getStatus());
			rtnString.append("\nLocation is: "+obj.getLocation());
			rtnString.append("\nTracking id: "+obj.getTracking_Id());
			rtnString.append("\nDelivery Date is on: "+obj.getDeliveryDate());
			rtnString.append("\nThe Product will be Delivered By "+obj.getDeliveryperson().getName()+" contact details of person is "+obj.getDeliveryperson().getContact_no());
			
			String rtn= rtnString.toString();
			return new ResponseEntity<>(rtn, HttpStatus.OK);	
		} catch(Exception e) {
			throw new TrackingNotFoundException();
		}
		
	}
	

}


