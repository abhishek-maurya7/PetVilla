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
public class PetOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petOrderId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "cId")
    @JsonBackReference // To prevent infinite loop during serialization
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "petId", referencedColumnName = "petId")
//    @JsonManagedReference
    private PetList pet;

    @Column(length = 20, nullable = false)
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(length = 20, nullable = false)
    private String status;
    
    @Override
    public String toString() {
        return "Customer{" +
                "oId=" + petOrderId +
                ", pet='" + customer + '\'' +
                ", pet='" + pet + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}