package com.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
