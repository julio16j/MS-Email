package com.jc.email.adapters.outbound.smtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jc.email.application.domain.Email;
import com.jc.email.application.ports.SendEmailServicePort;

@Service
public class SmtpSendEmailService implements SendEmailServicePort {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Override
	public void sendEmailSmtp(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email.getEmailFrom());
		message.setTo(email.getEmailTo());
		message.setSubject(email.getSubject());
		message.setText(email.getText());
		emailSender.send(message);
	}

}
