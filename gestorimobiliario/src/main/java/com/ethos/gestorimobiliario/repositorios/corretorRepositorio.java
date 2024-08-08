package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Corretor;

@Repository
public interface corretorRepositorio extends JpaRepository<Corretor,Long>{
    
}