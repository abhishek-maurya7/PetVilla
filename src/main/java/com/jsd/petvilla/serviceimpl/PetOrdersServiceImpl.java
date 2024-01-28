package com.jsd.petvilla.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.PetOrders;
import com.jsd.petvilla.exception.PetOrderIDNotFoundException;
import com.jsd.petvilla.repository.PetOrdersRepository;
import com.jsd.petvilla.service.PetOrdersService;

@Service
public class PetOrdersServiceImpl implements PetOrdersService {

	
	@Autowired
	PetOrdersRepository petOrdersRepository;

	/*
	 * saving new orders
	 * using .save() method of JpaRepository
 	 */
	@Override
	public PetOrders createPetOrder(PetOrders newPetOrder) {
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
}
