package com.jsd.petvilla.entity;

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
	
//	@Column(length = 20, nullable = false)
//	private int customerId;
	
//	@Column(length = 20, nullable = false)
//	private int productId;
	
	@OneToOne
	@JoinColumn(name="productId", referencedColumnName = "productId")
	private ProductList product;
	
	@Column(length = 20, nullable = false)
	private String orderDate;
	
	@Column(length = 20, nullable = false)
	private String status;
	
//	@ManyToOne
//    @JoinColumn(name = "customerId", referencedColumnName = "cId")
//    @JsonBackReference // To prevent infinite loop during serialization
//    private Customer customerOfProducts;
	
    @ManyToOne
    @JoinColumn(name = "customerId")  // Adjust the column name as needed
    @JsonBackReference // To prevent infinite loop during serialization
    private Customer customerOfProducts;
}
