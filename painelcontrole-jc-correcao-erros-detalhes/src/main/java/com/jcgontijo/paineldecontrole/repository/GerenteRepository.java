package com.jcgontijo.paineldecontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcgontijo.paineldecontrole.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente,Long>{
    
}
