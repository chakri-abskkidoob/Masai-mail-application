package com.masai.mail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mailId;
	private String toEmail;
	private String subject;
	private String description;
	private Boolean starred;
	private Boolean deleted;
}
