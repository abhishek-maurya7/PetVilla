package com.jsd.petvilla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsd.petvilla.entity.Login;

/*
 * Repository Interface to manage CRUD operations related to Login entity
 * Inherits methods of JpaRepository
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {
	/*
	 * method to find login information based on username and password
	 */
	public Login findByUsernameAndPassword(String username, String password);
	
	/**
	 * @param username
	 * @return boolean
	 */
	boolean existsByUsername(String username);
}
