package com.masai.mail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
	
	@Id
	private String email;
	private String toEmail;
	private String subject;
	private String description;
	private Boolean starred;
	private Boolean deleted;
}
