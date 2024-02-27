package com.Projetodto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetodto2.entities.Pet;

public interface PetRepository  extends JpaRepository<Pet, Long> {

}
