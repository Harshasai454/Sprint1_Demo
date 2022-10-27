package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
public class Authenticate1 {
	private Admin1 admin;
	private Tracking1 tracking;
	private Repair1 repair;

}
