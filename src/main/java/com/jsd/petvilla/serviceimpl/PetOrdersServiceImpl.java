package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.Customer;
import com.jsd.petvilla.entity.PetOrders;
import com.jsd.petvilla.exception.CustomerIDNotFoundException;
import com.jsd.petvilla.exception.PetOrderIDNotFoundException;
import com.jsd.petvilla.repository.CustomerRepository;
import com.jsd.petvilla.repository.PetOrdersRepository;
import com.jsd.petvilla.service.PetOrdersService;

@Service
public class PetOrdersServiceImpl implements PetOrdersService {
	@Autowired
	PetOrdersRepository petOrdersRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	/*
	 * saving new orders
	 * using .save() method of JpaRepository
 	 */
	@Override
	public PetOrders createPetOrder(PetOrders newPetOrder) {
	    Customer existingCustomer = customerRepository.findById(newPetOrder.getCustomer().getCId())
	            .orElseThrow(() -> new CustomerIDNotFoundException("Customer does not exist."));
	    newPetOrder.setCustomer(existingCustomer);
	    return petOrdersRepository.save(newPetOrder);
	}

	/*
	 * Fetch order based on the ID
	 * using .findById() from JpaRepository
 	 */
	@Override
	public PetOrders displayPetOrderById(int petOrderId) {
		return petOrdersRepository.findById(petOrderId).orElseThrow(() -> new PetOrderIDNotFoundException("Order does not exist."));
	}
	
	/*
	 * Cancel order based on the ID (update status to cancelled)
	 */
	@Override
	public PetOrders cancelPetOrder(PetOrders petOrder, int petOrderId) {
		PetOrders updatedPetOrder = petOrdersRepository.findById(petOrderId).orElseThrow(() -> new PetOrderIDNotFoundException("Order does not exist."));
		updatedPetOrder.setStatus(petOrder.getStatus());
		return petOrdersRepository.save(updatedPetOrder);
	}

    @Override
    public List<PetOrders> createPetOrders(List<PetOrders> newPetOrders) {
        // Iterate through the list of new orders and process each one
        for (PetOrders newPetOrder : newPetOrders) {
            // Retrieve the customer from the database using the provided customer ID
            Customer existingCustomer = customerRepository.findById(newPetOrder.getCustomer().getCId())
                    .orElseThrow(() -> new CustomerIDNotFoundException("Customer does not exist."));
            newPetOrder.setCustomer(existingCustomer);
        }
        // Save all the orders and return the list of saved orders
        return petOrdersRepository.saveAll(newPetOrders);
    }
}