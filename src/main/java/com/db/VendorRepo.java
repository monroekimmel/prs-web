package com.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer>{

}
