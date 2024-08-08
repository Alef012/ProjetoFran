package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Construtora;

@Repository
public interface ConstrutoraRepositorio extends JpaRepository<Construtora,Long>{
    
}
