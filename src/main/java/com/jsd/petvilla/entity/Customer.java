package com.jsd.petvilla.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    @Column(length=15, unique=true, nullable=false)
    private String username;
    
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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // To prevent infinite loop during serialization
    private List<PetOrders> petOrders;
    
    @OneToMany(mappedBy = "customerOfProducts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // To prevent infinite loop during serialization
    private List<ProductOrders> productOrders;
    
 // In the Customer entity
    @OneToMany(mappedBy = "pCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
    private List<Payments> payments;

    
    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cSurname='" + cSurname + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cPhone=" + cPhone +
                ", cAddress='" + cAddress + '\'' +
                '}';
    }
}