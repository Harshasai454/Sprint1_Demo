package com.example.sprint1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.Address1Dao;
import com.model.Address1;

@SpringBootTest
class ModelTest {
	
	@Autowired
	Address1Dao adao;


}
