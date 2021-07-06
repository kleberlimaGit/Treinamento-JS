package com.devfinances.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfinances.backend.entities.dto.FinancaDTO;
import com.devfinances.backend.services.FinancaService;

@RestController
@RequestMapping(value ="/financas")
public class FinancaController {

	@Autowired
	private FinancaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<FinancaDTO> bucarFinanca(@PathVariable Long id){
		FinancaDTO dto = service.extratoFinanca(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FinancaDTO> organizarFinancas(@PathVariable Long id, @RequestBody FinancaDTO dto){
		dto = service.organizarSalario(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
}
