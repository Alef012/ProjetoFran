package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Equipe;

@Repository
public interface EquipeRepositorio extends JpaRepository<Equipe,Long>{
    
}
