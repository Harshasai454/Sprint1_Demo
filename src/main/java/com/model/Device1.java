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
	
   /* @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_emp_id")
   // @JsonIgnore
	private Employee1 employee;
	*/

}