package com.devfinances.backend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devfinances.backend.entities.Entrada;
import com.devfinances.backend.entities.Financa;
import com.devfinances.backend.entities.Saida;
import com.devfinances.backend.entities.dto.EntradaDTO;
import com.devfinances.backend.entities.dto.FinancaDTO;
import com.devfinances.backend.entities.dto.SaidaDTO;
import com.devfinances.backend.repositories.EntradaRepository;
import com.devfinances.backend.repositories.FinancaRepository;
import com.devfinances.backend.repositories.SaidaRepository;
import com.devfinances.backend.services.exception.ResourceNotFoundException;

@Service
@Transactional
public class FinancaService {

	@Autowired
	private FinancaRepository repository;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private SaidaRepository saidaRepository;
	
	public FinancaDTO organizarSalario(Long id, FinancaDTO financaDto) {
		try {
			Financa financa = repository.getOne(id);			
			copiarSaldos(financa, financaDto);
			financa.setTotal(calcularTotal(financa.getEntradas(), financa.getSaidas()));
			financa = repository.save(financa);
			
			return new FinancaDTO(financa);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("NAO ENCONTRADO");
		}

	}
	
	@Transactional(readOnly = true)
	public FinancaDTO buscarFinanca(Long id) {
		Optional<Financa> obj = repository.findById(id);
		Financa financa = obj.orElseThrow(() -> new ResourceNotFoundException("NAO ENCONTRADO"));
		return new FinancaDTO(financa);
	}
	
	




	public double calcularTotal(List<Entrada> entradas, List<Saida> saidas) {
		
		double somarEntradas = entradas.stream().mapToDouble(valor -> valor.getValorEntrada()).sum();
		double somarSaidas = saidas.stream().mapToDouble(valor -> valor.getValorSaida()).sum();
		double total = somarEntradas - somarSaidas;
		return total;
	}
	
	public void copiarSaldos(Financa financa, FinancaDTO financaDto) {
		for(EntradaDTO entDto: financaDto.getEntradas()){
			Entrada entrada = entradaRepository.getOne(entDto.getId());
			financa.getEntradas().add(entrada);
			
		}
		
		for(SaidaDTO saidDto: financaDto.getSaidas()){
			Saida saida = saidaRepository.getOne(saidDto.getId());
			financa.getSaidas().add(saida);		
		}
	}
}
