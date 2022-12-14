package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address1 {
	
	@Id
	@GeneratedValue
	private int addressId; 
	private String street;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	
	@OneToOne(mappedBy="address")
	@JsonIgnore
	private Employee1 employee;

}
