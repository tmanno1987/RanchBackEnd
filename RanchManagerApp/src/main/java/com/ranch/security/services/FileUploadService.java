package com.ranch.security.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ranch.model.Users;
import com.ranch.repos.EmployeeRepo;

@Service
public class FileUploadService {
	@Autowired
	private EmployeeRepo er;
	
	public Users storeFile(MultipartFile file, String uname) throws Exception {
		// normalize file name
		String fname = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			// check if the files name contains invalid chars
			if(fname.contains("..")) {
				throw new Exception("Sorry! File name contains invalid characters..");
			}
			Optional<Users> user = er.findByUser(uname);
			if (user.get() != null) {
				user.get().setPicData(file.getBytes());
				return er.save(user.get());
			}
			return null;
		} catch(IOException ioe) {
			throw new Exception("Could not save " + fname);
		}
	}
	
	public Users getFile(long fid) throws FileNotFoundException {
		return er.findById(fid)
				.orElseThrow(() -> new FileNotFoundException("File not found with the current ID: " + fid));
	}
}











