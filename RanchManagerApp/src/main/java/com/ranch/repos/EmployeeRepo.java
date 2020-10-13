package com.ranch.repos;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Users;

@CrossOrigin()
public interface EmployeeRepo extends JpaRepository<Users, Long> {
	Page<Users> findByUserId(@RequestParam("id") Long id, Pageable pageable);
	
	Page<Users> findByUsernameContaining(@RequestParam("username") String user, Pageable pageable);
	
	// used for the security section
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Optional<Users> findByUsername(String username);
}