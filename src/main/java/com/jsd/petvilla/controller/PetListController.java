package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.PetList;
import com.jsd.petvilla.service.PetListService;

// rest controller to handle incoming requests related to Petlist entity
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PetListController {

	@Autowired
	PetListService pl;
	
	/*
	 * endpoint to fetch all pets
	 * @return ResponseEntity containing list of PetList object, HttpStatus OK if successful
	 */
	@GetMapping("/showPets")
	public ResponseEntity<List<PetList>> showAllPets() {
		return new ResponseEntity<List<PetList>>(pl.displayPets(), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch single pet by ID
	 * @return ResponseEntity containing PetList object, HttpStatus OK if successful
	 */
	@GetMapping("/showPet/{petId}")
	public ResponseEntity<PetList> showPetById(@PathVariable("petId") int petId) {
		return new ResponseEntity<PetList>(pl.displayPetById(petId), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch all pets of same category
	 * @return ResponseEntity containing list of PetList object, HttpStatus OK if successful
	 */
	@GetMapping("/showPets/category/{category}")
	public ResponseEntity<List<PetList>> showPetsByCategory(@PathVariable("category") String category) {
		return new ResponseEntity<List<PetList>>(pl.displayPetsByCategory(category), HttpStatus.OK);
	}
	
	/*
	 * endpoint to fetch all pets of same category
	 * @return ResponseEntity containing list of PetList object, HttpStatus OK if successful
	 */
	@GetMapping("/showPets/breed/{breed}")
	public ResponseEntity<List<PetList>> showPetsByBreed(@PathVariable("breed") String breed) {
		return new ResponseEntity<List<PetList>>(pl.displayPetsByBreed(breed), HttpStatus.OK);
	}
	
	@PostMapping("/addPet")
	public ResponseEntity<PetList> addPet(@RequestBody PetList pet) {
		return new ResponseEntity<PetList>(pl.addPet(pet), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletePet/{petId}")
	public ResponseEntity<String> deletePet(@PathVariable("petId") int petId) {
	    pl.deletePet(petId);
	    return new ResponseEntity<String>("Pet has been deleted. Poor him 😿.", HttpStatus.OK);
	}

}
