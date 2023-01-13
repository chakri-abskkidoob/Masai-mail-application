package com.masai.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.mail.dto.UserDTO;
import com.masai.mail.entity.Mail;
import com.masai.mail.entity.User;
import com.masai.mail.service.MailService;
import com.masai.mail.service.UserService;

@RestController
@RequestMapping("/masaimail")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		userService.register(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> logIn(@RequestBody UserDTO userdto){
		if(userService.login(userdto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/mail")
	public ResponseEntity<Mail> sendMail(@RequestBody Mail mail){
		mailService.sendmail(mail);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/mail/{email}")
	public List<Mail> getAllMails(@PathVariable String email){
		return mailService.getAllMails(email);
	}
	
	@PostMapping("/starred/{mailId}")
	public ResponseEntity<Mail> makeStarred(@PathVariable Long mailId){
		mailService.makeStarred(mailId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{mailId}")
	public ResponseEntity<Mail> deletemail(@PathVariable Long mailId){
		mailService.deleteMail(mailId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/starred/{email}")
	public List<Mail> getAllStarredMails(@PathVariable String email){
		return mailService.getAllStarredMails(email);
	}
	
	@PutMapping("/user/{email}")
	public User updateUserDetails(@PathVariable String email, @RequestBody User user){
		return userService.updateUserDetails(email, user);
	}

}
