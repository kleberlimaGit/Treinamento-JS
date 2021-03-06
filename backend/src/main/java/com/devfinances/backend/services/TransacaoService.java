package com.devfinances.backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devfinances.backend.entities.Transacoes;
import com.devfinances.backend.entities.dto.TransacaoDTO;
import com.devfinances.backend.repositories.FinancaRepository;
import com.devfinances.backend.repositories.TransacaoRepository;
import com.devfinances.backend.services.exception.ResourceNotFoundException;

@Service
@Transactional
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;
	
	@Autowired
	private FinancaRepository financaRepository;
	
	public TransacaoDTO cadastrarTransacao(TransacaoDTO dto) {
		Transacoes transacao = new Transacoes();
		transacao.setDescricao(dto.getDescricao());
		transacao.setValorTransacao(dto.getValorTransacao());
		transacao.setFinanca(financaRepository.findById(1L).get());
		transacao.setData(dto.getData());
		transacao = repository.save(transacao);
		
		return new TransacaoDTO(transacao);
	}
	
	public void deleterTransacao(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException  e) {
			throw new ResourceNotFoundException("Não encontrado");
		}
	}
}
