package com.devfinances.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devfinances.backend.entities.dto.TransacaoDTO;
import com.devfinances.backend.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoService service;
	
	@PostMapping
	public ResponseEntity<TransacaoDTO> cadastrarTransacao(@RequestBody TransacaoDTO dto) {
		dto = service.cadastrarTransacao(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<TransacaoDTO> excluirTransacao(@PathVariable Long id) {
		service.deleterTransacao(id);
		return ResponseEntity.noContent().build();
	}
	
}
