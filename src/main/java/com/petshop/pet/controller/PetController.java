package com.petshop.pet.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.petshop.pet.controller.dto.request.PetRequest;
import com.petshop.pet.model.Pet;
import com.petshop.pet.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

	private PetRepository repository;
	
	
	public PetController(PetRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@Valid @RequestBody PetRequest request, UriComponentsBuilder ucb) {
		Pet pet = request.toModel();
		
		repository.save(pet);
		
		URI uri = ucb.path("/pets/{id}")
					 .buildAndExpand(pet.getId())
					 .toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
