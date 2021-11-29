package com.jc.email.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.jc.email.adapters.outbound.persistence.entities.EmailEntity;
import com.jc.email.application.domain.Email;
import com.jc.email.application.domain.PageInfo;
import com.jc.email.application.ports.EmailRepositoryPort;

@Component
@Primary
public class EmailRepositoryImpl implements EmailRepositoryPort {
	
	private final JpaEmailRepository repository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public EmailRepositoryImpl (final JpaEmailRepository repository) {
		this.repository = repository;
		
	}
	
	@Override
	public Email save(Email email) {
		EmailEntity emailEntity = repository.save(modelMapper.map(email, EmailEntity.class));
		return modelMapper.map(emailEntity, Email.class);
	}

	@Override
	public List<Email> findAll(PageInfo pageInfo) {
		Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return repository.findAll(pageable).stream().map(entity -> modelMapper.map(entity, Email.class))
                .collect(Collectors.toList());
	}

	@Override
	public Optional<Email> findById(UUID emailId) {
		Optional<EmailEntity> emailEntity = repository.findById(emailId);
        if (emailEntity.isPresent()) {
            return Optional.of(modelMapper.map(emailEntity.get(), Email.class));
        } else {
            return Optional.empty();
        }
	}

}
