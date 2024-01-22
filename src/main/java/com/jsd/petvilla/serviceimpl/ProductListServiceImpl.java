package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.ProductList;
import com.jsd.petvilla.repository.ProductListRepository;
import com.jsd.petvilla.service.ProductListService;

//Implementing abstract methods of ProductService to handle CRUD operation related to ProductsErvice entity
@Service
public class ProductListServiceImpl implements ProductListService {

	@Autowired
	ProductListRepository productRepo;
	/*
	 * fetch all products
	 * @return A List of products
	 */
	@Override
	public List<ProductList> displayProducts() {
		return productRepo.findAll();
	}

	/*
	 * Fetch products of specific category
	 * @return A List of products belonging to required category
	 */
	@Override
	public List<ProductList> displayProductsByCategory(String productCategory) {
		return productRepo.findByCategory(productCategory);
	}

}
