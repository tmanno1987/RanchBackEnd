package com.ranch.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranch.model.MailMsg;
import com.ranch.security.services.MailService;

@RestController
public class RegistrationController {
	@Autowired
	private MailService mserv;
	
	@Autowired
	private MailMsg msg;
	
	@GetMapping("/send-mail")
	public String send() {
		msg.setEmailAddr("tmanno1987@gmail.com");
		msg.setSubject("test mail");
		msg.setBodyText("Good year yall!");
		
		try {
			mserv.sendEmail(msg);
		} catch(MailException me) {
			me.printStackTrace();
		}
		
		return "Your email was sent successfully.";
	}
	
	@GetMapping
	public String sendWithAttachment(@RequestBody MailMsg mm) throws MessagingException {
		mm.setEmailAddr("tmanno1987@gmail.com");
		mm.setSubject("testAttachment");
		mm.setBodyText("You did good job");
		
		try {
			mserv.sendEmailWithAttachment(mm);
		} catch (MailException me) {
			me.printStackTrace();
		}
		return "Mission accomplished.. You sent your mail plus attachment";
	}
}





