package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Unidade;

@Repository
public interface UnidadeRepositorio extends JpaRepository<Unidade,Long>{
    
}