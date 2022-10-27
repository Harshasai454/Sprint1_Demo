package com.model;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

 
@Data
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