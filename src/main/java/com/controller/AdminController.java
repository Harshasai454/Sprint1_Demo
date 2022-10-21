package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.Tracking1Dao;
import com.model.Tracking1;

@RestController
public class AdminController {
	
	@Autowired
	Tracking1Dao tdao;
	
	@PostMapping("/addtrackindetails")
	public ResponseEntity<String> addAddress(@RequestBody Tracking1 tracking) {
		
		tdao.save(tracking);
		return ResponseEntity.ok("Data Saved");
	}
	
	@GetMapping("/gettrackingetails")
	public List<Tracking1> getalldetails() {
		
		return tdao.findAll();
	}

}
