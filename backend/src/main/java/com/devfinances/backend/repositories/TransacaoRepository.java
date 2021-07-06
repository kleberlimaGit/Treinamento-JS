package com.devfinances.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devfinances.backend.entities.Transacoes;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacoes, Long>{

}
