package com.jsd.petvilla.exception;

public class PaymentRecordsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaymentRecordsNotFoundException(String message) {
		super(message);
	}
}
