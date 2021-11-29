package com.jc.email.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.email.model.dto.EmailDto;
import com.jc.email.model.entity.Email;
import com.jc.email.service.EmailService;

@RestController
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<Email> sendingEmail (@RequestBody @Valid EmailDto emailDto) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDto, email);
		email = emailService.sendEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
}
