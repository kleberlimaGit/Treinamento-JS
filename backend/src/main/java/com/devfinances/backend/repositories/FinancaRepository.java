package com.devfinances.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devfinances.backend.entities.Financa;

@Repository
public interface FinancaRepository extends JpaRepository<Financa, Long>{

}
