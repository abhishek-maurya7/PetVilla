package com.jsd.petvilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsd.petvilla.entity.PetList;



/*
 * Interface repository to manage CRUD operations related to PetList entity
 * Inherits methods of JpaRepository
 */
public interface PetListRepository extends JpaRepository<PetList, Integer>{
	/*
	 * Method to fetch Pets based on category
	 * Returns multiple Pets in a list
	 */
	@Query("Select petList from PetList petList where petList.category = ?1")
	List<PetList> findPetListByCategory(String category);
	
	/*
	 * Method to fetch Pets based on breed
	 * Returns multiple Pets in a list
	 */
	@Query("Select petList from PetList petList where petList.breed = ?1")
	List<PetList> findPetListByBreed(String breed);
}