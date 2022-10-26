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
    @JsonIgnore
    private Repair1 repair;
	
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name="fk_employee_id")
	private Employee1 employee;

}