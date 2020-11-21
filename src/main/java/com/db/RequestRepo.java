package com.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {
	
	List<Request> findByUserIdNotAndStatus(int id, String status);

}