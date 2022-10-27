package com.example.sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

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

import com.dao.DeliveryPerson1Dao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Employee1;
@SpringBootTest
class UserControllerTest1 {
	
	@Autowired
	DeliveryPerson1Dao dapdao;
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

}
