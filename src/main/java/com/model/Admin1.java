package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
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