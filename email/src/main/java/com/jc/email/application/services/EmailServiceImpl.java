package com.jc.email.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jc.email.application.domain.Email;
import com.jc.email.application.domain.PageInfo;
import com.jc.email.application.domain.enums.StatusEmail;
import com.jc.email.application.ports.EmailRepositoryPort;
import com.jc.email.application.ports.EmailServicePort;
import com.jc.email.application.ports.SendEmailServicePort;

public class EmailServiceImpl implements EmailServicePort {
	
	private final EmailRepositoryPort repository;
	
	private final SendEmailServicePort sendEmailServicePort;
	
	public EmailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
		this.repository = repository;
		this.sendEmailServicePort = sendEmailServicePort;
	}
	
	@Override
	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		try {
			sendEmailServicePort.sendEmailSmtp(email);
			email.setStatusEmail(StatusEmail.SENT);
		} catch (Exception e) {
			email.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return repository.save(email);
		}
	}

	@Override
	public List<Email> findAll(PageInfo pageInfo) {
		return repository.findAll(pageInfo);
	}

	@Override
	public Optional<Email> findById(UUID emailId) {
		return repository.findById(emailId);
	}
}
