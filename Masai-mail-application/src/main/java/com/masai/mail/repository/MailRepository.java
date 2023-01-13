package com.masai.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.mail.entity.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

}
