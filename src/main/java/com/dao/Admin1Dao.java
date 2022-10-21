package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Admin1;

@Repository
public interface Admin1Dao extends JpaRepository<Admin1, Integer> {

	public Admin1 findByAdminName(String adminname);

}
