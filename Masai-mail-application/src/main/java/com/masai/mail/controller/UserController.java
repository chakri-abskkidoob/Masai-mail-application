package com.masai.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
