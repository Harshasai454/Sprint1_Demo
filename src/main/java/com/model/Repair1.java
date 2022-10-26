package com.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
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
