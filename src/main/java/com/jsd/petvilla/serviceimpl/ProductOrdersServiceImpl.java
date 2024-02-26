package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.Customer;
import com.jsd.petvilla.entity.ProductOrders;
import com.jsd.petvilla.exception.CustomerIDNotFoundException;
import com.jsd.petvilla.exception.ProductOrderIDNotFoundException;
import com.jsd.petvilla.repository.CustomerRepository;
import com.jsd.petvilla.repository.ProductOrdersRepository;
import com.jsd.petvilla.service.ProductOrdersService;

/*
 * Implementation of methods of ProductOrdersService
 * handles CRUD operations for ProductOrders entity
 */
@Service
public class ProductOrdersServiceImpl implements ProductOrdersService {

	@Autowired
	ProductOrdersRepository productOrdersRepo;
	
	@Autowired
	CustomerRepository customerRepository;
	/*
	 * fetch information of specific product order by ID
	 * @return ProductOrders object corresponding to the ID
	 */
	@Override
	public ProductOrders fetchProductOrderById(int productOrderId) {
		return productOrdersRepo.findById(productOrderId).orElseThrow(() -> new ProductOrderIDNotFoundException("Product Order not found."));
	}

	/*
	 * save product order information
	 * @return saved ProductOrders object
	 */
	@Override
	public List<ProductOrders> createProductOrder(List<ProductOrders> newProductOrders) {
		return productOrdersRepo.saveAll(newProductOrders);
	}

	/*
	 * cancel product order by ID
	 * @return updated ProductOrders object
	 */
	@Override
	public ProductOrders cancelProductOrder(ProductOrders productOrder, int productOrderId) {
		ProductOrders updatedProductOrder = productOrdersRepo.findById(productOrderId).orElseThrow(() -> new ProductOrderIDNotFoundException("Order does not exist."));
		updatedProductOrder.setStatus(productOrder.getStatus());
		return productOrdersRepo.save(updatedProductOrder);
	}
}
