package com.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.LineItem;



public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

	//find line items with requestId
  public  List<LineItem> findAllByRequestId(int id);
}