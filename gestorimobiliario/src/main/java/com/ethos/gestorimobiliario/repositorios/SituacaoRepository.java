package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao,Long>{
    
}
