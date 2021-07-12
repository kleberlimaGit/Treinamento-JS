package com.devfinances.backend.entities.dto;

import java.time.LocalDate;

import com.devfinances.backend.entities.Transacoes;

public class TransacaoDTO {
	private Long id;
	private double valorTransacao;
	private String descricao;
	private LocalDate data;
	
	public TransacaoDTO() {
		
	}
	
	public TransacaoDTO(Long id, double valorTransacao, String descricao, LocalDate data) {
		this.id = id;
		this.valorTransacao = valorTransacao;
		this.descricao = descricao;
		this.data = data;
	}
	
	public TransacaoDTO(Transacoes entity) {
		id = entity.getId();
		valorTransacao = entity.getValorTransacao();
		descricao = entity.getDescricao();
		data = entity.getData();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

	
}
