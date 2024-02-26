package com.jsd.petvilla.service;

import java.util.List;

import com.jsd.petvilla.entity.PetOrders;

public interface PetOrdersService {
	/**
	 * method to save pet orders 
	 * @return saved PetOrders object
	 */
	PetOrders createPetOrder(PetOrders newPetOrder);
	
	/**
	 * fetch pet order information based on petOrderID
	 * @return PetOrders object
	 */
	PetOrders displayPetOrderById(int petOrderId);


	/**
	 * cancel pet order information based on petOrderID
	 * @return PetOrders object
	 */
	PetOrders cancelPetOrder(PetOrders updatedPetOrder, int petOrderId);

	/**
     * method to save multiple pet orders 
     * @return List of saved PetOrders objects
     */
    List<PetOrders> createPetOrders(List<PetOrders> newPetOrders);
}