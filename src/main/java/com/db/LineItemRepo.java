package com.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.business.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

	public List<LineItem> findByRequestId(int id);
	
   
}