package com.Projetodto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetodto2.DTO.petDTO;
import com.Projetodto2.entities.Pet;
import com.Projetodto2.service.PetService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "pet", description = "API REST DE GERECIAMENTO DE PET")
@RestController
@RequestMapping("/pet")
public class petController {
	
	private final PetService petService;

	@Autowired
	public petController(PetService petService) {
		this.petService = petService;
	}
	@PostMapping

	public ResponseEntity<petDTO> update(@RequestBody @Valid petDTO petDTO){

		petDTO salvarPet = petService.salvar(petDTO);

	return ResponseEntity.status(HttpStatus.CREATED).body(salvarPet);

	}


	@PutMapping("/{id}")

	public ResponseEntity<petDTO> update(@PathVariable Long id, @RequestBody @Valid petDTO petDTO){

		petDTO updatepetDTO = petService.update(id, petDTO);

	if(updatepetDTO != null) {

	return ResponseEntity.ok(updatepetDTO);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@DeleteMapping ("/{id}")

	public ResponseEntity<Pet> delete (@PathVariable Long id) {

	boolean delete = petService.delete(id);

	if (delete) {

	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@GetMapping("/{id}")

	public ResponseEntity<Pet> buscarPorId (@PathVariable Long id){

		Pet pet = petService.buscaPorId(id);

	if(pet != null) {

	return ResponseEntity.ok(pet);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}
	@GetMapping

	public ResponseEntity<List<Pet>> buscaTodos() {

	List <Pet> pet = petService.buscarTodos();

	return ResponseEntity.ok(pet);

	}



}
