package com.masai.mail.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.mail.dto.UserDTO;
import com.masai.mail.entity.User;
import com.masai.mail.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void register(User user) {
		userRepo.save(user);
	}
	
	public boolean validation(String a) {
		Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        
        Matcher hasDigit = digit.matcher(a);
        Matcher hasSpecial = special.matcher(a);
        
        if(hasDigit.find() || hasSpecial.find()) {
        	return true;
        }
        else {
        	return false;
        }
	}

	@Override
	public boolean login(UserDTO userdto) {
		User user = userRepo.findById(userdto.getEmail()).get();
		if(user.getPassword().equals(userdto.getPassword())) {
			user.setLoggedIn(true);
			userRepo.save(user);
			return true;
		}
		else {
			return false;
		}
	}

}
