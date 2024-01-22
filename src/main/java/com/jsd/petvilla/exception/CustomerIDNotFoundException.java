package com.jsd.petvilla.exception;

public class CustomerIDNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8459269492691026309L;

	public CustomerIDNotFoundException(String message) {
		super(message);
	}
}
