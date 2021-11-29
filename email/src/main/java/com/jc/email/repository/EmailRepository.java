package com.jc.email.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jc.email.model.entity.Email;

public interface EmailRepository extends JpaRepository<Email, UUID> {

}
