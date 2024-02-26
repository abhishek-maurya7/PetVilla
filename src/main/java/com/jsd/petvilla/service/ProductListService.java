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
	
	/*
	 * Fetch product by their name
	 * @param name Name of the product
	 * @return product information
	 */
	List<ProductList> displayProductsByName(String name);
	
	/*
	 * Fetch a specific product by ID
	 * @Param productId unique ID of the product
	 * @return information of specific product
	 */
	ProductList displayProductById(int productId);
	
	void deleteProduct(int productId);
	
	ProductList addNewProduct(ProductList newProduct);
	
}
