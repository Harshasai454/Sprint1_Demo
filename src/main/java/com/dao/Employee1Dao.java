package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee1;

@Repository
public interface Employee1Dao extends JpaRepository<Employee1, Integer> {

}
