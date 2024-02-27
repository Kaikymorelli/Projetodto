package com.Projetodto2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String nacimento;
	
	@NotNull
	@NotBlank
	private String cuidador;
	
	private String documento;

	public Pet(Long id, @NotNull @NotBlank String nome, @NotNull @NotBlank String nacimento,
			@NotNull @NotBlank String cuidador) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacimento = nacimento;
		this.cuidador = cuidador;
	}

	
	
}
