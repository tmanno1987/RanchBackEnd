package com.ranch.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranch.model.Roles;
import com.ranch.model.Users;
import com.ranch.model.enums.EnumRoles;
import com.ranch.payload.request.LoginRequest;
import com.ranch.payload.request.SignupRequest;
import com.ranch.payload.response.JwtResponse;
import com.ranch.payload.response.MessageResponse;
import com.ranch.repos.EmployeeRepo;
import com.ranch.repos.RoleRepo;
import com.ranch.security.jwt.JwtUtility;
import com.ranch.security.services.UserDetailsImpl;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	JwtUtility util;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest lr) {
		Authentication auth = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(lr.getUsername(), lr.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwt = util.generateJwtToken(auth);
		
		UserDetailsImpl userDets = (UserDetailsImpl) auth.getPrincipal();
		List<String> roles = userDets.getAuthorities().stream().map(e -> e.getAuthority()).collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt, userDets.getId(), userDets.getUsername(), userDets.getEmail(), roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest sr) {
		if (empRepo.existsByUsername(sr.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username already exists.."));
		}
		if (empRepo.existsByEmail(sr.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email already exists.."));
		}
		
		Users user = new Users(sr.getUsername(), encoder.encode(sr.getPassword()), sr.getFirstName(),
				sr.getLastName(), sr.getSalary(), sr.getEmail(), sr.getPhone(),
				sr.getAddress(), sr.getCity(), sr.getState(), sr.getZip());
		Set<String> strRoles = sr.getPosition();
		Set<Roles> roles = new HashSet<>();
		if (strRoles == null) {
			Roles userRole = roleRepo.findByName(EnumRoles.USER).orElseThrow(() -> new RuntimeException("Error: Role not found..")); 
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch(role) {
				case "mod":
					Roles mod = roleRepo.findByName(EnumRoles.MOD).orElseThrow(() -> new RuntimeException("Error: Role not found.."));
					roles.add(mod);
					break;
				case "admin":
					Roles admin = roleRepo.findByName(EnumRoles.ADMIN).orElseThrow(() -> new RuntimeException("Error: Role not found.."));
					roles.add(admin);
					break;
				default:
					Roles userRole = roleRepo.findByName(EnumRoles.USER).orElseThrow(() -> new RuntimeException("Error: Role not found..")); 
					roles.add(userRole);
				}
			});
		}
		
		user.setRoles(roles);
		empRepo.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User Registered Sucessfully!"));
	}
}