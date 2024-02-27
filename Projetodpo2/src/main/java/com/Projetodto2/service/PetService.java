package com.Projetodto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projetodto2.DTO.petDTO;
import com.Projetodto2.entities.Pet;
import com.Projetodto2.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private final PetRepository petRepository;
	
	@Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

	
	
	 public List<Pet> getAllpet () {
	        return petRepository.findAll();
	    }

	    public Pet getPetById(Long id) {
	        Optional<Pet> pet = petRepository.findById(id);
	        return pet.orElse(null);
	    }

	    public petDTO salvar(petDTO petDTO) {
	    	Pet pet = new Pet ( petDTO.id(), petDTO.nome(), petDTO.nacimento(), petDTO.cuidador());
	    	Pet salvarPet = petRepository.save(pet);
		
			return new petDTO (salvarPet.getId(), salvarPet.getNome(), salvarPet.getNacimento(), salvarPet.getCuidador() );
	    }

	    public petDTO update(Long id, petDTO petDTO) {
	    	Pet existePet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet nao encontrado"));
	    	existePet.setNome(petDTO.nome());
	    	existePet.setNacimento(petDTO.nacimento());
	    	
	    	Pet updatePet = petRepository.save(existePet);
	    	
	    	 return new petDTO (updatePet.getId(), updatePet.getNome(), updatePet.getNacimento(), updatePet.getCuidador() );
	        }
	       
	    

	    public boolean delete(Long id) {
	        Optional<Pet> existingPet = petRepository.findById(id);
	        if (existingPet.isPresent()) {
	        	petRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	    
	    public List <Pet> buscarTodos(){
	    return petRepository.findAll();	
	    }
	    
	    public Pet buscaPorId (Long id) {
	    	Optional <Pet> pet = petRepository.findById(id);
	    	return pet.orElse(null);
	    }

}
