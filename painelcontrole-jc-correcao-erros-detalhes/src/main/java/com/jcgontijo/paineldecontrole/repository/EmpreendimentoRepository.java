package com.jcgontijo.paineldecontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcgontijo.paineldecontrole.model.Empreendimento;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento,Long>{
    
}
