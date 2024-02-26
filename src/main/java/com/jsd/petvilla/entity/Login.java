package com.jsd.petvilla.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	@Column(length = 25, unique = true, nullable = false)
	private String username;
	
	@Column(length = 25, nullable = false)
	private String password;
	
	@Column(length=250, nullable=true)
	private String token;
}
