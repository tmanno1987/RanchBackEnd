package com.ranch.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String userAccess() {
		return "Customer Content.";
	}
	
	@GetMapping("/seasonal")
	@PreAuthorize("hasRole('SEASONAL')")
	public String seasonalAccess() {
		return "Seasonal Content.";
	}
	
	@GetMapping("/parttime")
	@PreAuthorize("hasRole('PARTTIME')")
	public String parttimeAccess() {
		return "Parttime Content.";
	}
	
	@GetMapping("/fulltime")
	@PreAuthorize("hasRole('FULLTIME')")
	public String fulltimeAccess() {
		return "Fulltime Content.";
	}
	
	@GetMapping("/cowboy")
	@PreAuthorize("hasRole('COWBOY')")
	public String cowboyAccess() {
		return "Coyboy Content.";
	}
	
	@GetMapping("/manager")
	@PreAuthorize("hasRole('MANAGER')")
	public String managerAccess() {
		return "Manager Content.";
	}
	
	@GetMapping("/owner")
	@PreAuthorize("hasRole('OWNER')")
	public String ownerAccess() {
		return "Owner Content.";
	}
}