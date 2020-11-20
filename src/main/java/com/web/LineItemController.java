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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.LineItem;
import com.db.LineItemRepo;

@CrossOrigin
@RestController
@RequestMapping("/lineitems")
public class LineItemController {

	@Autowired
	private LineItemRepo lineItemRepo;
	
	@GetMapping("/")
	public List<LineItem> getAll() {
		return lineItemRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<LineItem> getById(@PathVariable int id) {
		return lineItemRepo.findById(id);
	}

	@PostMapping("/")
	public LineItem addPLineItem(@RequestBody LineItem l) {
		l = lineItemRepo.save(l);
		return l;
	}

	@PutMapping("/")
	public LineItem updateLineItem(@RequestBody LineItem l) {
		l = lineItemRepo.save(l);
		return l;
	}

	@DeleteMapping("/{id}")
	public LineItem deletePLineItem(@PathVariable int id) {
		// Optional type will wrap a line item
		Optional<LineItem> l = lineItemRepo.findById(id);
		// isPresent() will return true if a line item was found
		if (l.isPresent()) {
			lineItemRepo.deleteById(id);
		} else {
			System.out.println("Error - line item not found for id " + id);
		}
		return l.get();
	}
	
		@GetMapping("/lines-for-pr/{id}")
		public List<LineItem> getLineItemByPr(@PathVariable int id) {
			return lineItemRepo.findAllByRequestId(id);
		}


}