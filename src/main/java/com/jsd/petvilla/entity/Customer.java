package com.jsd.petvilla.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	@Column(length = 20, nullable = false)
	private String cName;
	
	@Column(length = 20)
	private String cSurname;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "Email is mandatory.")
	@Email(message = "Invalid email format. Please enter again")
	private String cEmail;
	
	@Column(length = 12, nullable = false, unique = true)
	@NotNull(message = "Phone number is mandatory.")
	private long cPhone;
	
	@Column(length = 40, nullable = false)
	private String cAddress;
}