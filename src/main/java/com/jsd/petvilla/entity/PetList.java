package com.jsd.petvilla.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;
	
	@Column(length = 20, nullable = false)
	private String category;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String breed;
	
	@Column(length = 20, nullable = false)
	private String color;
	
	@Column(length = 200, nullable = false)
	private String description;
	
	@Column(length = 15, nullable = false)
	private String dateOfListing;
	
	@Column(length = 5, nullable = false)
	private int price;
}