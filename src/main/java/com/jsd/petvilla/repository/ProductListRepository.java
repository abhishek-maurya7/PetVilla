package com.jsd.petvilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsd.petvilla.entity.ProductList;

/*
 * Interface repository to manage CRUD operations related to ProductList entity
 * Inherits methods of JpaRepository
 */
public interface ProductListRepository extends JpaRepository<ProductList, Integer>{
	/*
	 * Custom method to fetch products based on category
	 * Returns list of of products from same category
	 */
	@Query("Select productList from ProductList productList where productList.productCategory = ?1")
	List<ProductList> findByCategory(String productCategory);
	
	/*
	 * Custom method to fetch product by name
	 * @param name Name of the product
	 * @return information of specific product
	 */
	@Query("Select productList from ProductList productList where productList.name = ?1")
	List<ProductList> findByName(String name);
}