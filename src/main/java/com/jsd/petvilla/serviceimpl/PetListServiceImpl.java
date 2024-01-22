package com.jsd.petvilla.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.PetList;
import com.jsd.petvilla.exception.PetIDNotFoundException;
import com.jsd.petvilla.repository.PetListRepository;
import com.jsd.petvilla.service.PetListService;

//Implementation of abstract methods of PetListService Interface
//Handling different kinds of fetch operation for PetList entity
@Service
public class PetListServiceImpl implements PetListService{
	/*
	 * Injecting PetListRepository using autowired
	 */
	@Autowired
	PetListRepository plRepo;

	/*
	 * Method to fetch all pets 
	 * Using .findAll() method of JpaRepository
	 * Returns a List
	 */
	@Override
	public List<PetList> displayPets() {
		return plRepo.findAll();
	}

	/*
	 * Method to fetch pets based on category
	 * @Param cateory 
	 * Using .findPetListByCategory() method of PetListRepository
	 * Returns a List
	 */
	@Override
	public List<PetList> displayPetsByCategory(String category) {
		// TODO Auto-generated method stub
		return plRepo.findPetListByCategory(category);
	}
	
	/*
	 * Method to fetch pets based on breed
	 * @Param breed 
	 * Using .findPetListByBreed() method of PetListRepository
	 * Returns a List
	 */
	@Override
	public List<PetList> displayPetsByBreed(String breed) {
		return plRepo.findPetListByBreed(breed);
	}


	@Override
	public PetList displayPetById(int petId) {
		return plRepo.findById(petId).orElseThrow(() -> new PetIDNotFoundException("Pet does not exist."));
	}
}
