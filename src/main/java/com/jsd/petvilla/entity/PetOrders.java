package com.jsd.petvilla.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petOrderId;
	
	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "cId")
	Customer customer;
	
	@OneToOne
	@JoinColumn(name = "petId", referencedColumnName = "petId")
	private PetList pet;
	
	@Column(length = 20, nullable = false)
	private String orderDate;
	
	@Column(length = 20, nullable = false)
	private String status;
}