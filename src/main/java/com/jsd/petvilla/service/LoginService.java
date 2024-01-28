package com.jsd.petvilla.service;

import com.jsd.petvilla.entity.Login;

public interface LoginService {
	/**
	 * Method to perform login using username and password 
	 */
	public Login loginCustomer(String username, String password);
}
