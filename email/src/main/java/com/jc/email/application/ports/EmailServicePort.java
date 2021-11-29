package com.jc.email.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jc.email.application.domain.Email;
import com.jc.email.application.domain.PageInfo;

public interface EmailServicePort {
	
	Email sendEmail(Email email);
	List<Email> findAll(PageInfo pageInfo);
	Optional<Email> findById (UUID emailId);
}
