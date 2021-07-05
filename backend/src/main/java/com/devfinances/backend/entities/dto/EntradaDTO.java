package com.devfinances.backend.entities.dto;

import com.devfinances.backend.entities.Entrada;

public class EntradaDTO {
	private Long id;
	private double valorEntrada;
	private String descricao;
	
	public EntradaDTO() {
		
	}
	
	public EntradaDTO(Long id, double valorEntrada, String descricao) {
		this.id = id;
		this.valorEntrada = valorEntrada;
		this.descricao = descricao;
	}
	
	public EntradaDTO(Entrada entity) {
		id = entity.getId();
		valorEntrada = entity.getValorEntrada();
		descricao = entity.getDescricao();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
}
