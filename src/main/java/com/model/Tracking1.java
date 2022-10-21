package com.model;

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
    
    @OneToOne(cascade=CascadeType.ALL)
    private DeliveryPerson1 deliveryperson;

}