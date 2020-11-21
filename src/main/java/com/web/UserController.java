package com.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.business.User;
import com.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable int id) {
		return userRepo.findById(id);
	}

	@PostMapping("/")
	public User addUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User u) {
		u = userRepo.save(u);
		return u;
	}

	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) {
		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			userRepo.deleteById(id);
		} else {
			System.out.println("Error - user not found for id " + id);
		}
		return u.get();
	}

	@PostMapping("/login")
	public Optional<User> login(@RequestBody User u) {
		Optional<User> user = userRepo.findByUserNameAndPassword(u.getUserName(), u.getPassword());
		if (user.isPresent()) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
}