package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.ProductList;
import com.jsd.petvilla.service.ProductListService;

@RestController
public class ProductListController {

	@Autowired
	ProductListService productListService;
	
	@GetMapping("/showProducts")
	public ResponseEntity<List<ProductList>> showAllProducts() {
		return new ResponseEntity<List<ProductList>>(productListService.displayProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/showProducts/{productCategory}")
	public ResponseEntity<List<ProductList>> showProdcutsByCategory(@PathVariable("productCategory") String productCategory) {
		return new ResponseEntity<List<ProductList>>(productListService.displayProductsByCategory(productCategory), HttpStatus.OK);
	}
}
