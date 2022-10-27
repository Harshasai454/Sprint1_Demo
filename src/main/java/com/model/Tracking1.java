package com.model;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

 
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tracking1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tracking_Id;
    private String location;
    private String status;  
    
    private Date deliveryDate;
    
    @OneToOne(cascade=CascadeType.ALL)
    private DeliveryPerson1 deliveryperson;

}