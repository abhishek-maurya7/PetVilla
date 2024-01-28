package com.jsd.petvilla.exception;

public class ProductCategoryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFoundException(String message) {
		super(message);
	}
}
