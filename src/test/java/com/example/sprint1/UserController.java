package com.example.sprint1;

//import static org.junit.jupiter.api.Assertions.*;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.DeliveryPerson1Dao;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class UserController {
	
	@Autowired
	DeliveryPerson1Dao dapdao;
	
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
    void testGetDeliveryPerson() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/getdeliveryperson/1";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
    void testGetTracking() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/gettrackingdetails/1";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}

}
