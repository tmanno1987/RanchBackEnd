package com.ranch.controllers;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ranch.model.Users;
import com.ranch.security.services.FileUploadService;

@RestController
public class FileController {
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileUploadService fus;
	
	@PostMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("user") String uname) {
		Users user = fus.storeFile(file, uname);
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(user.getId()).toUriString();
	}
	
	@PostMapping("/uploadMultipleFiles")
	public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		Arrays.asList(files).stream().max((file,uname) -> uploadFile(file,uname)).collect(Collectors.toList());
	}
}






