package com.example.sprint1;


import static org.assertj.core.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dao.Device1Dao;
import com.dao.Employee1Dao;
import com.dao.Repair1Dao;
import com.dao.Tracking1Dao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Admin1;
import com.model.Device1;
import com.model.Employee1;
import com.model.Repair1;
import com.model.Tracking1;

@SpringBootTest
class AdminControllerTest1 {
	
	@Autowired
	Tracking1Dao tdao;
	@Autowired
	Employee1Dao edao;
	@Autowired
	Device1Dao ddao;
	@Autowired 
	Repair1Dao rdao;
	
	Tracking1 tracking = new Tracking1();
	Admin1 admin = new Admin1();
	Device1 device = new Device1();
	Repair1 repair = new Repair1();
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
	void testAddUser() throws URISyntaxException, JsonProcessingException {
	      RestTemplate template=new RestTemplate();
	      final String url="http://localhost:8080/addadmin";
	      URI uri=new URI(url);
	      HttpHeaders headers = new HttpHeaders();      
	      HttpEntity<Admin1> ht = new HttpEntity<>(admin, headers);
	      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
	      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		}

	@Test
	void testAddTracking() throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://localhost:8080/addtrackindetails";
		      URI uri=new URI(url);
		      HttpHeaders headers = new HttpHeaders();      
		      HttpEntity<Tracking1> ht = new HttpEntity<>(tracking, headers);
		      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			}  catch (HttpClientErrorException ex) {
				Assertions.assertEquals("404 : \"Admin Not Found!\"", ex.getMessage());
		    }
			}

	@Test
	void testAddRepair() throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://localhost:8080/addrepairdetails";
		      URI uri=new URI(url);
		      HttpHeaders headers = new HttpHeaders();      
		      HttpEntity<Repair1> ht = new HttpEntity<>(repair, headers);
		      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			}  catch (HttpClientErrorException ex) {
				Assertions.assertEquals("404 : \"Please Check Admin details or Device Details!\"", ex.getMessage());
				
		    }
			}

	@Test
	void testAddDevice()  throws URISyntaxException, JsonProcessingException {
	try {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/adddevice";
      URI uri=new URI(url);
      HttpHeaders headers = new HttpHeaders();      
      HttpEntity<Device1> ht = new HttpEntity<>(device, headers);
      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}catch (HttpClientErrorException ex) {
		Assertions.assertEquals("404 : \"Employee Not Found!\"", ex.getMessage());
    }
	}
	
	@Test
    void testEmployeeDeviceDetails() throws HttpClientErrorException, URISyntaxException, JsonParseException{
        try {
            int id=1;
            Employee1 emp1=new Employee1();
            emp1.setEmpId(id);
            edao.save(emp1);
            Device1 device=new Device1();
            device.setDeviceId(id);
            device.setEmployee(emp1);
            device.setConpanyName("capg");
            device.setDeviceConfig("hp");
            ddao.save(device);
            RestTemplate template=new RestTemplate();
            final String url="http://localhost:8080/adddevice";
            URI uri=new URI(url);
            HttpHeaders headers = new HttpHeaders();      
            HttpEntity<Device1> ht = new HttpEntity<>(device, headers);
            ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
           assertThat(res.getStatusCode().equals(HttpStatus.OK));  
        }
        catch (HttpClientErrorException ex) {
           Assertions.assertEquals("404 : \"Employee Not Found!\"", ex.getMessage());
        }
    }
	
	//    Dao for device
    @Test
    void testAddDeviceDao() throws Exception {
        device.setDeviceId(1);
        device.setEmployee(null);
        device.setRepair(null);
        device.setConpanyName("Apple Macbook");
        device.setDeviceConfig("Macbook M1");
        ddao.save(device);
        Assertions.assertNotNull(ddao.findById(device.getDeviceId()).get());
    }
    


/*
	@Test
	void testUpdateDrtails() throws URISyntaxException, JsonProcessingException {
		try {
		      RestTemplate template=new RestTemplate();
		      final String url="http://http://localhost:8080/updatetrackingdetails/1";
		      URI uri=new URI(url);
		      HttpHeaders headers = new HttpHeaders();      
		      HttpEntity<Tracking1> ht = new HttpEntity<>(tracking, headers);
		      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
			}  catch (HttpClientErrorException ex) {
				Assertions.assertEquals("404 : \"Tracking Id is not found or Details Yet to update !\"", ex.getMessage());
				
		    }
			}
			*/

	@Test
	void testGetrepairdetails() throws URISyntaxException, JsonProcessingException {
	      RestTemplate template=new RestTemplate();
	      final String url="http://localhost:8080/getrepairdetails";
	      URI uri=new URI(url);
	      ResponseEntity<String> res=template.getForEntity(uri,String.class);
	      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		}

	@Test
	void testGetalldetails() throws URISyntaxException, JsonProcessingException {
	      RestTemplate template=new RestTemplate();
	      final String url="http://localhost:8080/gettrackingetails";
	      URI uri=new URI(url);
	      ResponseEntity<String> res=template.getForEntity(uri,String.class);
	      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		}

}
