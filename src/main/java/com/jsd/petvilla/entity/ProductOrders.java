package com.jsd.petvilla.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class ProductOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productOrderId;
	

	@ManyToOne
	@JoinColumn(name="productId", referencedColumnName = "productId")
	private ProductList product;
	
	@Column(length = 20, nullable = false)
	private LocalDateTime orderDate = LocalDateTime.now();
	
	@Column(length = 3, nullable = false)
	private int quantity;
	
	@Column(length = 20, nullable = false)
	private String status;
	
    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonBackReference 
    private Customer customerOfProducts;
}
