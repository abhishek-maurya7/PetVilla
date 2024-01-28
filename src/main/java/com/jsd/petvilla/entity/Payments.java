package com.jsd.petvilla.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "cId")
    @JsonIgnore
    private Customer pCustomer;
    
    @ManyToOne
    @JoinColumn(name = "petOrderId", nullable = true)
    private PetOrders petOrder;

    @ManyToOne
    @JoinColumn(name = "productOrderId", nullable = true)
    private ProductOrders productOrder;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private int amount;

    @Column(length = 20, nullable = false)
    private String paymentMethod;
}
