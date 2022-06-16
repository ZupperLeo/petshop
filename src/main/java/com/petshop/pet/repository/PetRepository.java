package com.petshop.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.pet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
