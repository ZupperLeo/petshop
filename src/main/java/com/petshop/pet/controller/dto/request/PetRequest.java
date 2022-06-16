package com.petshop.pet.controller.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petshop.pet.model.Pet;
import com.petshop.pet.model.enums.Tipo;

public class PetRequest {

	@NotBlank
	private String nome;
	
	@NotNull
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotNull
	private String tipo;
	
	@NotBlank
	private String raca;
	
	public PetRequest(){}

	public PetRequest(@NotBlank String nome, @NotNull @PastOrPresent LocalDate dataNascimento, @NotNull String tipo,
			@NotBlank String raca) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipo = tipo;
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getTipo() {
		return tipo;
	}

	public String getRaca() {
		return raca;
	}
	
	public Pet toModel() {
		return new Pet(nome, dataNascimento, Tipo.setTipo(tipo), raca);
	}
	
}
