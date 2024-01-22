package com.jsd.petvilla.service;

import com.jsd.petvilla.entity.PetOrders;

public interface PetOrdersService {
//	PetOrders createOrder(PetOrders petOrder);
	
	PetOrders fetchPetOrderById(int petOrderId);
	
	PetOrders createPetOrder(PetOrders newPetOrder);
}
