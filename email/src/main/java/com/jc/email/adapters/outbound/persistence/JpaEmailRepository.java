package com.jc.email.adapters.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.email.adapters.outbound.persistence.entities.EmailEntity;

public interface JpaEmailRepository extends JpaRepository<EmailEntity, UUID> {

}
