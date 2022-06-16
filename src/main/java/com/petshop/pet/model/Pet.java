package com.petshop.pet.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.petshop.pet.model.enums.Tipo;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	@PastOrPresent
	private LocalDate dataNascimento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@NotBlank
	@Column(nullable = false)
	private String raca;
	
	@Deprecated
	public Pet() {}

	public Pet(@NotBlank String nome, @NotNull @PastOrPresent LocalDate dataNascimento, @NotNull Tipo tipo,
			@NotBlank String raca) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipo = tipo;
		this.raca = raca;
	}
	
	public Long getId() {
		return id;
	}
	
}
