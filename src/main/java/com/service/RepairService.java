package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.Device1Dao;
import com.dao.Employee1Dao;
import com.dao.Repair1Dao;
import com.model.Device1;
import com.model.Employee1;
import com.model.Repair1;

public class RepairService {
	
	@Autowired
	Repair1Dao rdao;
	
	@Autowired 
	Device1Dao ddao;
	
	@Autowired 
	Employee1Dao edao;
	
	public void addRepair(Repair1 repair) {	
		Repair1 repair1=new Repair1();
		Device1 device=ddao.findById(repair.getDevice().getDeviceId()).get();
		Employee1 employee=device.getEmployee();
		repair1.setDevice(device);
		repair1.setEmpName(employee.getName());
		repair1.setEmpUserName(employee.getUserName());
		repair1.setIssue(repair.getIssue());
		repair1.setRepairCost(repair.getRepairCost());
		repair1.setSolution(repair.getSolution());
		repair1.setStatus(repair.getStatus());
		rdao.save(repair1);
}

	public Employee1 getEmployee(int roll) {
		return edao.findById(roll).get();
	}
	
	// Save device
	
	public void addDevice(Device1 device) {
		ddao.save(device);
	}
	
	public Repair1 getRepair(int repairid) {
		Repair1 repair=rdao.findById(repairid).get();
		return repair;
	}
	
	public void updateRepair(Repair1 repair) {
		rdao.save(repair);
	}
	

}
