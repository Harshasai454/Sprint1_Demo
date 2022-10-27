package com.example.sprint1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dao.Address1Dao;
import com.dao.DeliveryPerson1Dao;
import com.dao.Repair1Dao;
import com.dao.Tracking1Dao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Address1;
import com.model.DeliveryPerson1;
import com.model.Employee1;
import com.model.Repair1;
import com.model.Tracking1;
@SpringBootTest
class UserControllerTest1 {
	
	@Autowired
	DeliveryPerson1Dao dpdao;
	@Autowired
	Address1Dao adao;
	@Autowired
	Tracking1Dao tdao;
	@Autowired
	Repair1Dao rdao; 
	
	Employee1 employee = new Employee1();
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception{
	}
	@BeforeEach
	void setUp() throws Exception{
	}
	@AfterEach
	void tearDown() throws Exception{
	}

	@Test
	void testAddUser()  throws URISyntaxException, JsonProcessingException {
	      RestTemplate template=new RestTemplate();
	      final String url="http://localhost:8080/addadmin";
	      URI uri=new URI(url);
	      HttpHeaders headers = new HttpHeaders();      
	      HttpEntity<Employee1> ht = new HttpEntity<>(employee, headers);
	      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
	      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		}

	@Test
	void testGetdetails() throws URISyntaxException, JsonProcessingException {
	      try {
	  		RestTemplate template=new RestTemplate();
	        final String url="http://localhost:8080/getdeliveryperson/1";
	        URI uri=new URI(url);
	        ResponseEntity<String> res=template.getForEntity(uri,String.class);
	        Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	  	}catch (HttpClientErrorException ex) {
	  		Assertions.assertEquals("404 : \"Delivery Person Id is not valid or Details Yet to update !\"", ex.getMessage());
	      }
	  	}

	@Test
	void testGettrackingdetails() throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://localhost:8080/gettrackingdetails/1";
		      URI uri=new URI(url);
		      ResponseEntity<String> res=template.getForEntity(uri,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			} catch (HttpClientErrorException ex) {
		        Assertions.assertEquals("404 : \"Tracking Id is not found or Details Yet to update !\"", ex.getMessage());
		    }
			}

	@Test
	void testGetrepair()throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://localhost:8080/getrepairdetails/1";
		      URI uri=new URI(url);
		      ResponseEntity<String> res=template.getForEntity(uri,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			} catch (HttpClientErrorException ex) {
		        Assertions.assertEquals("404 : \"Repair Details Id is not valid or Details Yet to update !\"", ex.getMessage());
		    }
			}

	@Test
	void testFindByPk() throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://localhost:8080/gettrackingbyId/1";
		      URI uri=new URI(url);
		      ResponseEntity<String> res=template.getForEntity(uri,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			} catch (HttpClientErrorException ex) {
		        Assertions.assertEquals("404 : \"Tracking Id is not found or Details Yet to update !\"", ex.getMessage());
		    }
			}
	
	@Test
    void testGetAddressFromDao() throws Exception {
        Address1 add = new Address1(1,"old Street","Hyderabad","Telangana","500002","India",null);
        adao.save(add);
        Address1 add1 = adao.findById(add.getAddressId()).get();
        Address1 add2 = new Address1();
        add2.setAddressId(add1.getAddressId());
        add2.setCity(add1.getCity());
        add2.setCountry(add1.getCountry());
        add2.setEmployee(add1.getEmployee());
        add2.setPinCode(add1.getPinCode());
        add2.setState(add1.getState());
        add2.setStreet(add1.getStreet());
        Assertions.assertEquals(add2.getAddressId(), add.getAddressId());
    }

	@Test
	void testgetTrackingFromDao() throws Exception{
		Tracking1 t = new Tracking1(1,"Hyderabad","on the way",new Date(2022-11-03),null);
		tdao.save(t);
		Tracking1 t1 = tdao.findById(t.getTracking_Id()).get();
		Tracking1 t2 = new Tracking1();
		t2.setTracking_Id(t1.getTracking_Id());
		t2.setStatus(t1.getStatus());
		t2.setLocation(t1.getLocation());
		t2.setDeliveryDate(t1.getDeliveryDate());
		t2.setDeliveryperson(t1.getDeliveryperson());
		Assertions.assertEquals(t2.getTracking_Id(),t.getTracking_Id());
		
	}
	
	@Test
	void testRepairFromDao() throws Exception{
		Repair1 r = new Repair1(1,"Harsha","harsha04","not opening","Repaired","change battery",500,null);
		rdao.save(r);
		Repair1 r1 = rdao.findById(r.getRepairId()).get();
		Repair1 r2 = new Repair1();
		r2.setRepairId(r1.getRepairId());
		r2.setEmpName(r1.getEmpName());
		r2.setEmpUserName(r1.getEmpUserName());
		r2.setIssue(r1.getIssue());
		r2.setStatus(r1.getStatus());
		r2.setSolution(r1.getSolution());
		r2.setRepairCost(r1.getRepairCost());
		r2.setDevice(r1.getDevice());
		Assertions.assertEquals(r2.getEmpName(), r.getEmpName());
	}
	
	@Test
	void testDeliveryPersonFromDao() throws Exception{
		DeliveryPerson1 dp = new DeliveryPerson1(1,"Harsha","123456789",null);
		dpdao.save(dp);
		DeliveryPerson1 dp1 = dpdao.findById(dp.getPerson_id()).get();
		DeliveryPerson1 dp2 = new DeliveryPerson1();
		dp2.setName(dp1.getName());
		dp2.setPerson_id(dp1.getPerson_id());
		dp2.setContact_no(dp1.getContact_no());
		dp2.setTracking(dp1.getTracking());
		Assertions.assertEquals(dp2.getName(), dp.getName());
	}
}
