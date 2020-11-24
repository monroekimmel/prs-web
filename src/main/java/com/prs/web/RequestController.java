package com.prs.web;

import java.time.LocalDateTime;
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

import com.prs.business.Request;

import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/requests")
public class RequestController {

	@Autowired
	private RequestRepo requestRepo;

	@GetMapping("/")
	public List<Request> getAll() {
		return requestRepo.findAll();
	}

	@GetMapping("/list-review/{id}")
	public List<Request> getRequestsInReview(@PathVariable int id) {
		return requestRepo.findByUserIdNotAndStatus(id, "review");
	}

	@GetMapping("/{id}")
	public Optional<Request> getById(@PathVariable int id) {
		return requestRepo.findById(id);
	}

	@PostMapping("/")
	public Request addRequest(@RequestBody Request r) {
		r.setStatus("New");
		r.setSubmittedDate(LocalDateTime.now());
		r = requestRepo.save(r);
		return r;
	}

	@PutMapping("/")
	public Request updateRequest(@RequestBody Request r) {
		r = requestRepo.save(r);
		return r;
	}

	@PutMapping("/submit-review")
	public Request submitRequestForReview(@RequestBody Request r) {
		if (r.getTotal() <= 50.0) {
			r.setStatus("Approved");
		} else {
			r.setStatus("Review");
		}
		r.setSubmittedDate(LocalDateTime.now());
		r = requestRepo.save(r);
		return r;
	}

	@PutMapping("/approve")
	public Request approveRequest(@RequestBody Request r) {
		r.setStatus("Approved");
		r = requestRepo.save(r);
		return r;
	}

	@PutMapping("/reject")
	public Request rejectRequest(@RequestBody Request r) {
		r.setStatus("Rejected");
		r = requestRepo.save(r);
		return r;

	}

	@DeleteMapping("/{id}")
	public Request deleteRequest(@PathVariable int id) {
		Optional<Request> r = requestRepo.findById(id);
		if (r.isPresent()) {
			requestRepo.deleteById(id);
		} else {
			System.out.println("Error - request not found for id " + id);
		}
		return r.get();
	}

}
