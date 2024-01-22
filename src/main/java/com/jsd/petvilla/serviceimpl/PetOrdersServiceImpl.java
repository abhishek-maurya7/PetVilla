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

	@Override
	public PetOrders fetchPetOrderById(int petOrderId) {
		return petOrdersRepository.findById(petOrderId).orElseThrow(() -> new PetOrderIDNotFoundException("Order does not exist."));
	}

	@Override
	public PetOrders createPetOrder(PetOrders newPetOrder) {
		return petOrdersRepository.save(newPetOrder);
	}
}
