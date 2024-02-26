package com.jsd.petvilla.service;

import com.jsd.petvilla.entity.Login;

public interface LoginService {
	/**
	 * Method to perform login using username and password 
	 */
	public Login loginUser(String username, String password, String token);
	
	/**
	 * Method to perform registration using username and password 
	 */
	public String registerUser(Login credientials);
	
	/**
	 * @param username
	 * @return boolean
	 */
	boolean isUsernameAvailable(String username);
}
