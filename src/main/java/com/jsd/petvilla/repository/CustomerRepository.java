package com.jsd.petvilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.petvilla.entity.Customer;

/*
 * Interface repository to manage CRUD operations related to Customer entity
 * Inherits methods of JpaRepository
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}