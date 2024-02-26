package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.ProductList;
import com.jsd.petvilla.service.ProductListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductListController {

	@Autowired
	ProductListService productListService;
	
	/*
	 * endpoint to fetch all products 
	 * @return ResponseEntity containing List of ProductList object, HttpStatus OK if successful 
	 */
	@GetMapping("/showProducts")
	public ResponseEntity<List<ProductList>> showAllProducts() {
		return new ResponseEntity<List<ProductList>>(productListService.displayProducts(), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch products based on name
	 * @return RsponseEntity containing List of ProductList object, HttpStatus OK if successful
	 */
	@GetMapping("/showProduct/{name}")
	public ResponseEntity<List<ProductList>> showProductByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<ProductList>>(productListService.displayProductsByName(name), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch products based on productCategory
	 * @return RsponseEntity containing List of ProductList object, HttpStatus OK if successful
	 */
	@GetMapping("/showProducts/{productCategory}")
	public ResponseEntity<List<ProductList>> showProdcutsByCategory(@PathVariable("productCategory") String productCategory) {
		return new ResponseEntity<List<ProductList>>(productListService.displayProductsByCategory(productCategory), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch single products by ID
	 * @return RsponseEntity containing ProductList object, HttpStatus OK if successful
	 */
	@GetMapping("/showProduct/id/{productId}")
	public ResponseEntity<ProductList> showProductsByCategory(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductList>(productListService.displayProductById(productId), HttpStatus.OK);
	}
	
	
    @DeleteMapping("product/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
        productListService.deleteProduct(productId);
        return new ResponseEntity<String>("Product has been deleted 😿", HttpStatus.OK);
    }
	
	@PostMapping("/product/addNewProduct")
	public ResponseEntity<ProductList> addNewProduct(@RequestBody ProductList newProduct) {
		return new ResponseEntity<ProductList>(productListService.addNewProduct(newProduct), HttpStatus.CREATED);
	}
}
