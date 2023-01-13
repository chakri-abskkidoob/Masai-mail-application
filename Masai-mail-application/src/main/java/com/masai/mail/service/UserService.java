package com.masai.mail.service;

import com.masai.mail.dto.UserDTO;
import com.masai.mail.entity.User;

public interface UserService {

	void register(User user);

	boolean login(UserDTO userdto);

	User updateUserDetails(String email, User user);

}
