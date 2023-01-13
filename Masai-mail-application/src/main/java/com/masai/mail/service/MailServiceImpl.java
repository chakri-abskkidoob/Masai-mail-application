package com.masai.mail.service;

import java.util.List;

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

	@Override
	public List<Mail> getAllMails(String email) {
		return mailRepo.findByUserEmailId(email);
	}

	@Override
	public void makeStarred(Long mailId) {
		Mail m = mailRepo.findBymailId(mailId);
		m.setStarred(true);
		mailRepo.save(m);
	}

	@Override
	public void deleteMail(Long mailId) {
		Mail m = mailRepo.findBymailId(mailId);
		m.setDeleted(true);
		mailRepo.save(m);
	}

	@Override
	public List<Mail> getAllStarredMails(String email) {
		List<Mail> mails = mailRepo.findByUserEmailId(email);
		return mails.stream().filter( e -> e.getStarred() == true).toList();
	}
}
