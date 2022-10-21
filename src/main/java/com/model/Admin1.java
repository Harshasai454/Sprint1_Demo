package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="it_staff")
public class Admin1 {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int adminId;
	 private String adminName;
	 private String contactNo;
	 private String designation;
	 private String password;
	 
	// private Request requestlist; 
	

}