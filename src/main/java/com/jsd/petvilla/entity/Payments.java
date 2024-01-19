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
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(length = 20, nullable = false)
    private int customerId;
    
    @Column(length = 20, nullable = false)
    private int petOrderId;
    
    @Column(length = 20, nullable = false)
    private int productOrderId;
    
    @Column(length = 20, nullable = false)
    private String paymentDate;
    
    @Column(length = 20, nullable = false)
    private int amount;
    
    @Column(length = 20, nullable = false)
    private String paymentMethod;
}