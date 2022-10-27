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
public class DeliveryPerson1 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int person_id;
	private String name;
	private String contact_no;
	
	@OneToOne(mappedBy="deliveryperson")
	@JsonIgnore
	private Tracking1 tracking;
	

}

