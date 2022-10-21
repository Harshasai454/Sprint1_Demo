package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dao.DeliveryPerson1Dao;
import com.model.DeliveryPerson1;

@RestController
public class UserController {
	
	@Autowired
	DeliveryPerson1Dao dpdao;
	
	@GetMapping("/getdeliveryperson")
	public List<DeliveryPerson1> getdetails() {
		return  dpdao.findAll();
	}
	

}


