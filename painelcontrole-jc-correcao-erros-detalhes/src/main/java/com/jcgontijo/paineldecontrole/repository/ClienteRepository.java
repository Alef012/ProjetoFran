package com.jcgontijo.paineldecontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcgontijo.paineldecontrole.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
