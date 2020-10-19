package com.ranch.security.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ranch.model.MailMsg;

@Service
public class MailService {
	private JavaMailSender jms;
	
	@Autowired
	public MailService(JavaMailSender jms) {
		this.jms = jms;
	}
	
	public void sendEmail(MailMsg m) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(m.getEmailAddr());
		mail.setSubject(m.getSubject());
		mail.setText(m.getBodyText());
		
		jms.send(mail);
	}
	
	public void sendEmailWithAttachment(MailMsg m) throws MailException, MessagingException {
		MimeMessage mm = jms.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(mm,true);
		
		help.setTo(m.getEmailAddr());
		help.setSubject(m.getSubject());
		help.setText(m.getBodyText());
		
		ClassPathResource cpr = new ClassPathResource("Attachment.pdf");
		help.addAttachment(cpr.getFilename(), cpr);
		
		jms.send(mm);
	}
}