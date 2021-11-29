package com.jc.email.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jc.email.EmailApplication;
import com.jc.email.application.ports.EmailRepositoryPort;
import com.jc.email.application.ports.EmailServicePort;
import com.jc.email.application.ports.SendEmailServicePort;
import com.jc.email.application.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;

@Configuration
@ComponentScan(basePackageClasses = EmailApplication.class)
public class BeanConfiguration {
	
	@Bean
	EmailServicePort emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
		return new EmailServiceImpl(repository, sendEmailServicePort);
	}
	
	@Bean
	public ModelMapper modelMapper () {
		return new ModelMapper();
	}
}
