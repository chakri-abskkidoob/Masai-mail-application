package com.masai.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.mail.entity.Mail;
import com.masai.mail.repository.MailRepository;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	private MailRepository mailRepo;

	@Override
	public void sendmail(Mail mail) {
		mail.setDeleted(false);
		mail.setStarred(false);
		mailRepo.save(mail);
		
	}
}
