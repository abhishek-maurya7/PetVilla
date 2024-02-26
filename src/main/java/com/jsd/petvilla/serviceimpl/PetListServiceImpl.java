package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.PetList;
import com.jsd.petvilla.exception.PetBreedNotFoundException;
import com.jsd.petvilla.exception.PetCategoryNotFoundException;
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
	 * @param category 
	 * Using .findPetListByCategory() method of PetListRepository
	 * @return a List of pets having same category
	 */
	@Override
	public List<PetList> displayPetsByCategory(String category) {
		List<PetList> petList = plRepo.findPetListByCategory(category);
		if(petList.isEmpty()) {
			throw new PetCategoryNotFoundException("Pets of " + category + " not found.");
		}
		return plRepo.findPetListByCategory(category);
	}
	
	/*
	 * Method to fetch pets based on breed
	 * @param breed 
	 * Using .findPetListByBreed() method of PetListRepository
	 * @throws PetBreedNotFoundException 
	 * @returns a List pets having same breed
	 */
	@Override
	public List<PetList> displayPetsByBreed(String breed) {
		List<PetList> petList = plRepo.findPetListByBreed(breed);
		if(petList.isEmpty()) {
			throw new PetBreedNotFoundException("Pets of " + breed + " not found.");
		}
		return petList;
	}


	/*
	 * Fetch single pet by ID
	 * Using .findById() from JpaRepository
 	 * @param petId Pet ID of each pet
	 * @return information of the pet
	 */
	@Override
	public PetList displayPetById(int petId) {
		return plRepo.findById(petId).orElseThrow(() -> new PetIDNotFoundException("Pet does not exist."));
	}

	@Override
	public PetList addPet(PetList pet) {
		return plRepo.save(pet);
	}

	@Override
	public void deletePet(int petId) {
	    PetList pet = plRepo.findById(petId).orElseThrow(() -> new PetIDNotFoundException("Pet does not exist."));
	    plRepo.delete(pet);
	}

}
