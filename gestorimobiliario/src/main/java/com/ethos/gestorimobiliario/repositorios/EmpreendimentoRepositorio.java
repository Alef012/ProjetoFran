package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Empreendimento;

@Repository
public interface EmpreendimentoRepositorio extends JpaRepository<Empreendimento,Long>{
    
}
