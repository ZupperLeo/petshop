package com.petshop.pet.model.enums;

public enum Tipo {
	CAO(1, "Cão"),
	GATO(2, "Gato");
	
	private String descricao;
	private Integer cod;
	
	Tipo(Integer cod, String tipo) {
		this.cod = cod;
		this.descricao = tipo;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Tipo setTipo(String tipo) {
		if (tipo == null) {
			return null;
		}
		
		for (Tipo pet : Tipo.values()) {
			if (tipo.equals(pet.getDescricao())) {
				return pet;
			}
		}
		throw new IllegalArgumentException("Tipo de pet não cadastrado!");
	}
	
}
