package com.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.business.Vendor;

import com.db.VendorRepo;


@CrossOrigin
@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepo vendorRepo;

	@GetMapping("/")
	public List<Vendor> getAll() {
		return vendorRepo.findAll();
	}
	
		@GetMapping("/{id}")
		public Optional<Vendor> getById(@PathVariable int id) {
			return vendorRepo.findById(id);
		}
		
		@PostMapping("/")
		public Vendor addVendor(@RequestBody Vendor v) {
			v = vendorRepo.save(v);
			return v;
		}
		
		@PutMapping("/")
		public Vendor updateVendor(@RequestBody Vendor v) {
			v = vendorRepo.save(v);
			return v;
		}

		@DeleteMapping("/{id}")
		public Vendor deleteUser(@PathVariable int id) {
			Optional<Vendor> v = vendorRepo.findById(id);
			if (v.isPresent()) {
				vendorRepo.deleteById(id);
			} else {
				System.out.println("Error - vendor not found for id " + id);
			}
			return v.get();
		}

}
