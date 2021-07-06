package com.devfinances.backend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devfinances.backend.entities.Financa;
import com.devfinances.backend.entities.Transacoes;
import com.devfinances.backend.entities.dto.FinancaDTO;
import com.devfinances.backend.entities.dto.TransacaoDTO;
import com.devfinances.backend.repositories.FinancaRepository;
import com.devfinances.backend.repositories.TransacaoRepository;
import com.devfinances.backend.services.exception.ResourceNotFoundException;

@Service
@Transactional
public class FinancaService {

	@Autowired
	private FinancaRepository repository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public FinancaDTO organizarSalario(Long id, FinancaDTO financaDto) {
		try {
			Financa financa = repository.getOne(id);			
			copiarTransacao(financa, financaDto);
			financa.setTotal(calcularTotal(financa.getTransacoes()));
			financa = repository.save(financa);
			
			return new FinancaDTO(financa);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("NAO ENCONTRADO");
		}

	}
	
	public FinancaDTO extratoFinanca(Long id) {
		Optional<Financa> obj = repository.findById(id);
		Financa financa = obj.orElseThrow(() -> new ResourceNotFoundException("NAO ENCONTRADO"));
		financa.setTotal(calcularTotal(financa.getTransacoes()));
		repository.save(financa);
		return new FinancaDTO(financa);
	}
	
	




	public double calcularTotal(List<Transacoes> transacoes) {
	
		double total = transacoes.stream().mapToDouble(x -> x.getValorTransacao()).sum();
		return total;
	}
	
	public void copiarTransacao(Financa financa, FinancaDTO financaDto) {
		for(TransacaoDTO entDto: financaDto.getTransacoes()){
			Transacoes entrada = transacaoRepository.getOne(entDto.getId());
			financa.getTransacoes().add(entrada);
			
		}
		
	}
}
