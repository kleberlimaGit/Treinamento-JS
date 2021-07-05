package com.devfinances.backend.entities.dto;

import java.util.ArrayList;
import java.util.List;

import com.devfinances.backend.entities.Financa;

public class FinancaDTO {

	private Long id;
	private List<EntradaDTO> entradas = new ArrayList<>();
	private List<SaidaDTO> saidas = new ArrayList<>();
	private double total;
	
	public FinancaDTO() {
		
	}
	
	public FinancaDTO(Long id, List<EntradaDTO> entradas, List<SaidaDTO> saidas) {
		this.id = id;
		this.entradas = entradas;
		this.saidas = saidas;
	}
	
	public FinancaDTO(Financa entity) {
		id = entity.getId();
		entity.getEntradas().forEach(entrada -> this.entradas.add(new EntradaDTO(entrada)));
		entity.getSaidas().forEach(saida -> this.saidas.add(new SaidaDTO(saida)));
		total = entity.getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EntradaDTO> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<EntradaDTO> entradas) {
		this.entradas = entradas;
	}

	public List<SaidaDTO> getSaidas() {
		return saidas;
	}

	public void setSaidas(List<SaidaDTO> saidas) {
		this.saidas = saidas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
