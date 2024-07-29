package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long>{
    
}
