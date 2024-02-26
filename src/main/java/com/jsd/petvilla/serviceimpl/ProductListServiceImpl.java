package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.ProductList;
import com.jsd.petvilla.exception.ProductCategoryNotFoundException;
import com.jsd.petvilla.exception.ProductIDNotFoundException;
import com.jsd.petvilla.exception.ProductNameNotFoundException;
import com.jsd.petvilla.repository.ProductListRepository;
import com.jsd.petvilla.service.ProductListService;

//Implementing abstract methods of ProductService to handle CRUD operation related to ProductsErvice entity
@Service
public class ProductListServiceImpl implements ProductListService {

	@Autowired
	ProductListRepository productRepo;
	/*
	 * fetch all products
	 * using .findAll() from JpaRepository
	 * @return A List of products
	 */
	@Override
	public List<ProductList> displayProducts() {
		return productRepo.findAll();
	}

	/*
	 * Fetch products of specific category
	 * using .findByCategory method from ProductListRepository
	 * @return A List of products belonging to required category
	 */
	@Override
	public List<ProductList> displayProductsByCategory(String productCategory) {
		List<ProductList> productList = productRepo.findByCategory(productCategory);
		if(productList.isEmpty()) {
			throw new ProductCategoryNotFoundException("Products of " + productCategory + " not found.");
		}
		return productList;
	}
	
	/*
	 * Fetch product of specific ID
	 * @param productId ID of product
	 * @return single product information
	 */
	@Override
	public ProductList displayProductById(int productId) {
		return productRepo.findById(productId).orElseThrow(() -> new ProductIDNotFoundException("Product ID not found."));
	}

	/*
	 * Fetch product by name
	 * using .fetchByName() method of ProductListRepository
 	 */
	@Override
	public List<ProductList> displayProductsByName(String name) {
		List<ProductList> productList = productRepo.findByName(name);
		if(productList.isEmpty()) {
			throw new ProductNameNotFoundException("Nothing matching found.");
		}
		return productList;
	}

    @Override
    public void deleteProduct(int productId) {
        productRepo.findById(productId).orElseThrow(() -> new ProductNameNotFoundException("Product was not found."));
        productRepo.deleteById(productId);
    }

	@Override
	public ProductList addNewProduct(ProductList newProduct) {
		return productRepo.save(newProduct);
	}
}
