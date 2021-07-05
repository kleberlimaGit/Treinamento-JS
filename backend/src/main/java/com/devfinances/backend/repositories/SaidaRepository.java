package com.devfinances.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devfinances.backend.entities.Saida;
@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long>{

}
