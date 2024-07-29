package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
    
}
