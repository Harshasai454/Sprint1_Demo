package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import lombok.Data;


@Data
@Entity
public class Employee1 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String department;
    

   /* @OneToOne(cascade=CascadeType.ALL)
    private Device1 device;*/
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_add_id")
    private Address1 address;
    
   /* @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Complaints> complaint;*/

}