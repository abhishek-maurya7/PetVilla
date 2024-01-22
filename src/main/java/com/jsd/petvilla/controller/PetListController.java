package com.jsd.petvilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsd.petvilla.entity.PetList;
import com.jsd.petvilla.service.PetListService;

@RestController
public class PetListController {

	@Autowired
	PetListService pl;
	
	@GetMapping("/showPets")
	public ResponseEntity<List<PetList>> showAllPets() {
		return new ResponseEntity<List<PetList>>(pl.displayPets(), HttpStatus.OK);
	}
	
	@GetMapping("/showPet/{petId}")
	public ResponseEntity<PetList> showPetById(@PathVariable("petId") int petId) {
		return new ResponseEntity<PetList>(pl.displayPetById(petId), HttpStatus.OK);
	}
	@GetMapping("/showPets/category/{category}")
	public ResponseEntity<List<PetList>> showPetsByCategory(@PathVariable("category") String category) {
		return new ResponseEntity<List<PetList>>(pl.displayPetsByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/showPets/breed/{breed}")
	public ResponseEntity<List<PetList>> showPetsByBreed(@PathVariable("breed") String breed) {
		return new ResponseEntity<List<PetList>>(pl.displayPetsByBreed(breed), HttpStatus.OK);
	}
}
