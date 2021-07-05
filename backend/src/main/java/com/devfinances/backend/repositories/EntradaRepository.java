package com.devfinances.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devfinances.backend.entities.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{

}
