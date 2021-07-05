package com.devfinances.backend.entities.dto;

import com.devfinances.backend.entities.Saida;

public class SaidaDTO {
	private Long id;
	private double valorSaida;
	private String descricao;
	
	public SaidaDTO() {
		
	}
	
	public SaidaDTO(Long id, double valorSaida, String descricao) {
		this.id = id;
		this.valorSaida = valorSaida;
		this.descricao = descricao;
	}
	
	public SaidaDTO(Saida entity) {
		id = entity.getId();
		valorSaida = entity.getValorSaida();
		descricao = entity.getDescricao();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(double valorSaida) {
		this.valorSaida = valorSaida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
