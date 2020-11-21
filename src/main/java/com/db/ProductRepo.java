package com.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}