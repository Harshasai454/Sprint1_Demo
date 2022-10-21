package com.example.sprint1;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.Tracking1Dao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Tracking1;

@SpringBootTest
class AdminControllerTest {
	
	@Autowired
	Tracking1Dao tdao;
	Tracking1 tracking = new Tracking1();
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
	//dao
	@Test
	void testAddTracking() {
		tracking.setLocation("Mumbai");
		tracking.setStatus("on the way");
		tdao.save(tracking);
		Tracking1 t = tdao.findById(tracking.getTracking_Id()).get();
		Assertions.assertEquals(tracking.getTracking_Id(), t.getTracking_Id());
	}
	@Test
    void testAddTracking1() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/addtrackindetails";
      URI uri=new URI(url);
      HttpHeaders headers = new HttpHeaders();      
      HttpEntity<Tracking1> ht = new HttpEntity<>(tracking, headers);
      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
    void testGetTracking() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/gettrackingetails";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}

}
