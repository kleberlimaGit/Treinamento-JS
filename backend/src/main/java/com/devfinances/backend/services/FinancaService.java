package com.devfinances.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfinances.backend.entities.Entrada;
import com.devfinances.backend.entities.Financa;
import com.devfinances.backend.entities.Saida;
import com.devfinances.backend.entities.dto.FinancaDTO;
import com.devfinances.backend.repositories.FinancaRepository;

@Service
public class FinancaService {

	@Autowired
	private FinancaRepository repository;
	
	public FinancaDTO organizarSalario(FinancaDTO financaDto) {
		Financa financa = new Financa();
		for(financaDto.getEntradas() entDto : financaD)
		
		
		
		financa = repository.save(financa);
		
		return financaDto;
	}
	
	public Financa buscarFinanca(Long id) {
		Financa financa = repository.findById(id).get();
		return financa;
	}
	
	public double calcularTotal(List<Entrada> entradas, List<Saida> saidas) {
		
		double somarEntradas = entradas.stream().mapToDouble(valor -> valor.getValorEntrada()).sum();
		double somarSaidas = saidas.stream().mapToDouble(valor -> valor.getValorSaida()).sum();
		double total = somarEntradas - somarSaidas;
		return total;
	}
}
