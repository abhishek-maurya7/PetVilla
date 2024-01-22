package com.jsd.petvilla.exception;

public class PetOrderIDNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PetOrderIDNotFoundException(String message) {
		super(message);
	}
}
