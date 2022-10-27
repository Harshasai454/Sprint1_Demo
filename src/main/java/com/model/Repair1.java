package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Repair1
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int repairId;
    private String empName;
    private String empUserName;
    private String issue;
    private String  status;
    private String solution;
    private float repairCost;
    
    @OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name="fk_device_id")
	private Device1 device;
 
}
