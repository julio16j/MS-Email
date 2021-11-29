package com.jc.email.application.ports;

import com.jc.email.application.domain.Email;

public interface SendEmailServicePort {
	
	void sendEmailSmtp(Email email);
}
