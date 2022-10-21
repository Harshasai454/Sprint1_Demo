package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Device1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;
	private String conpanyName;
	private String deviceConfig;
	
	@OneToOne(mappedBy="device")
	private Employee1 empId;

}