package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.controllerexp.AdminNotFoundException;
import com.controllerexp.AdminOrDeviceNotFoundException;
import com.controllerexp.EmployeeNotFoundException;
import com.controllerexp.RepairNotFoundException;
import com.controllerexp.TrackingNotFoundException;
import com.dao.Admin1Dao;
import com.dao.DeliveryPerson1Dao;
import com.dao.Device1Dao;
import com.dao.Repair1Dao;
import com.dao.Tracking1Dao;
import com.model.Admin1;
import com.model.Authenticate1;
//import com.model.DeliveryPerson1;
import com.model.Device1;
import com.model.Repair1;
import com.model.Tracking1;

@RestController
public class AdminController {
	
	@Autowired
	Tracking1Dao tdao;
	@Autowired
	DeliveryPerson1Dao dpdao;
	@Autowired
	Admin1Dao adao;
	@Autowired 
	Repair1Dao rdao;
	@Autowired
	Device1Dao ddao;
	
	
	@GetMapping("/adminhome")
	public String gethome() {
		return "Welcome to Admin Home Page";
	}
	
	
	@PostMapping("/addadmin")
	 public ResponseEntity<?> addUser(@RequestBody Admin1 admin)
    {
        adao.save(admin);
        return new ResponseEntity<>("user added successfully",HttpStatus.OK);

    }
	@PostMapping("/addtrackindetails")
	public ResponseEntity<?> addTracking(@RequestBody Authenticate1 authenticate) {
		
		try {
		String adminname = authenticate.getAdmin().getAdminName();
		String password = authenticate.getAdmin().getPassword();
		
		Admin1 adminexist = adao.findByAdminName(adminname);
		if(adminexist.getAdminName().equals(adminname)&&adminexist.getPassword().equals(password)) {
			Tracking1 tracking = authenticate.getTracking();
			tdao.save(tracking);
			return ResponseEntity.ok("Data Saved");
		}
		else {
		 return ResponseEntity.ok("Admin not Found");
		}
		}
		catch(Exception e) {
			throw new AdminNotFoundException();
		}
		
	}
	
	@PostMapping("/addrepairdetails")
	public ResponseEntity<?> addRepair(@RequestBody Authenticate1 authenticate) {
		try {
		String adminname = authenticate.getAdmin().getAdminName();
		String password = authenticate.getAdmin().getPassword();
		
		Admin1 adminexist = adao.findByAdminName(adminname);
		if(adminexist.getAdminName().equals(adminname)&&adminexist.getPassword().equals(password)) {
			Repair1 repair = authenticate.getRepair();
			rdao.save(repair);
			return ResponseEntity.ok("Repair Data Saved");
		}
		else {
		 return new ResponseEntity<>("Admin credientials not found",HttpStatus.OK);
		}
		}
		catch(Exception e) {
			throw new AdminOrDeviceNotFoundException();
		}
	}
	
	@PostMapping("/adddevice")
	public ResponseEntity<?> addDevice(@RequestBody Device1 device){
		try {
			ddao.save(device);
			return new ResponseEntity<>("device request Submitted!", HttpStatus.OK);

	}catch(Exception e) {
		throw new EmployeeNotFoundException();
	}
	}
	
	@PatchMapping("/updatetrackingdetails/{tracking_id}")
	public ResponseEntity<String> updateDrtails(@PathVariable int tracking_id, Tracking1 tracking){
		try {
		Tracking1 uptrack = tdao.findById(tracking_id).get();
		//DeliveryPerson1 updel = dpdao.findById(tracking_id).get();
		uptrack.setStatus(tracking.getStatus());
		uptrack.setDeliveryDate(tracking.getDeliveryDate());
		uptrack.setLocation(tracking.getLocation());
		tdao.save(uptrack);
		return new ResponseEntity<>("Tracking details updated !", HttpStatus.OK);
	}catch(Exception e) {
		throw new TrackingNotFoundException();
	}
	}
	
	@GetMapping("/getrepairdetails")
	public List<Repair1> getrepairdetails() throws RepairNotFoundException{
		try {
		
		return rdao.findAll();
	}catch(Exception e) {
		throw new RepairNotFoundException();
	}
	}
	
	
	@GetMapping("/gettrackingetails")
	public List<Tracking1> getalldetails() throws TrackingNotFoundException {
		try {
		return tdao.findAll();
	}catch(Exception e) {
		throw new TrackingNotFoundException();
	}
	}

}
