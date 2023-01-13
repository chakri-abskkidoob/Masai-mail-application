package com.masai.mail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.mail.entity.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

	
	@Query(value = "select m.* from mail m join user u on u.email = m.email where u.email = ?1", nativeQuery = true)
	List<Mail> findByUserEmailId(String email);

	Mail findBymailId(Long mailId);

}
