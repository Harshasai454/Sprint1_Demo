package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.controllerexp.AdminNotFoundException;
import com.dao.Admin1Dao;
import com.dao.Repair1Dao;
import com.dao.Tracking1Dao;
import com.model.Admin1;
import com.model.Authenticate1;
import com.model.Repair1;
import com.model.Tracking1;

@RestController
public class AdminController {
	
	@Autowired
	Tracking1Dao tdao;
	@Autowired
	Admin1Dao adao;
	@Autowired 
	Repair1Dao rdao;
	
	
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
	public ResponseEntity<?> addAddress(@RequestBody Authenticate1 authenticate) {
		
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
			throw new AdminNotFoundException();
		}
	}
	
	@GetMapping("/getrepairdetails")
	public List<Repair1> getrepairdetails() {
		
		return rdao.findAll();
	}
	
	
	@GetMapping("/gettrackingetails")
	public List<Tracking1> getalldetails() {
		
		return tdao.findAll();
	}

}
