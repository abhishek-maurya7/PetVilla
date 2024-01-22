package com.jsd.petvilla.service;

import java.util.List;

import com.jsd.petvilla.entity.ProductList;

public interface ProductListService {
	/*
	 * Abstract method to fetch all products
	 * @return a List
	 */
	List<ProductList> displayProducts();
	
	/*
	 * Abstract method to fetch products of specific category
	 * @param productCategory A category of products
	 * @return A List of ProductList having required category
	 */
	List<ProductList> displayProductsByCategory(String productCategory);
}
