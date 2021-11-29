package com.jc.email.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import com.jc.email.application.domain.enums.StatusEmail;

import lombok.Data;

@Data
public class Email {
	
	private UUID emailId;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private String text;
	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;
	
}
