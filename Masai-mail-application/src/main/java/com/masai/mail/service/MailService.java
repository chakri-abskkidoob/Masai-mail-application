package com.masai.mail.service;

import java.util.List;

import com.masai.mail.entity.Mail;

public interface MailService {

	void sendmail(Mail mail);

	List<Mail> getAllMails(String email);

	void makeStarred(Long mailId);

	void deleteMail(Long mailId);

	List<Mail> getAllStarredMails(String email);

}
