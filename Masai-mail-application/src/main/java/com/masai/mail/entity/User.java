package com.masai.mail.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private LocalDate dateOfBirth;
	private Boolean loggedIn;
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Mail> mails;
	
}
