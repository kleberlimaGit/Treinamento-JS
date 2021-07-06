package com.devfinances.backend.entities.dto;

import java.util.ArrayList;
import java.util.List;

import com.devfinances.backend.entities.Financa;

public class FinancaDTO {

	private Long id;
	private List<TransacaoDTO> transacoes = new ArrayList<>();
	private double total;
	
	public FinancaDTO() {
		
	}
	
	public FinancaDTO(Long id, List<TransacaoDTO> transacoes) {
		this.id = id;
		this.transacoes = transacoes;
	}
	
	public FinancaDTO(Financa entity) {
		id = entity.getId();
		entity.getTransacoes().forEach(transacao -> this.transacoes.add(new TransacaoDTO(transacao)));
		total = entity.getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TransacaoDTO> getTransacoes() {
		return transacoes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
