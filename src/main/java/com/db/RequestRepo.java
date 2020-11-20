package com.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {
	
	// Get all requests in review status and userId != id
	List<Request> findByUserIdNotAndStatus(int id, String status);

}