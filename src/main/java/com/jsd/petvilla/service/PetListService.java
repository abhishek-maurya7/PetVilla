package com.jsd.petvilla.service;

import java.util.List;

import com.jsd.petvilla.entity.PetList;

//Service interface to perform CRUD operations related to the Customer Entity
public interface PetListService {
	/*
	 * Method to display all pets
	 * Returns all pets in List
	 */
	List<PetList> displayPets();
	
	/*
	 * Method to fetch single pet using ID
	 * @param petId ID of the pet
	 * @return PetList
	 */
	PetList displayPetById(int petId);
	
	/*
	 * Method to fetch pets of specific category
	 * Returns pets of specific category in a List
	 */
	List<PetList> displayPetsByCategory(String category);
	
	/*
	 * Method to fetch display pets of specific breed
	 * Returns pets of specific breed in a List
	 */
	List<PetList> displayPetsByBreed(String breed);
	
	PetList addPet(PetList pet);
	
	void deletePet(int petId);
}
