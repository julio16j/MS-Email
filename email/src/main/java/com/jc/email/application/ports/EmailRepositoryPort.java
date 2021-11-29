package com.jc.email.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.jc.email.application.domain.Email;
import com.jc.email.application.domain.PageInfo;

public interface EmailRepositoryPort {
	
	Email save(Email email);
	List<Email> findAll(PageInfo pageable);
	Optional<Email> findById(UUID emailId);
}
