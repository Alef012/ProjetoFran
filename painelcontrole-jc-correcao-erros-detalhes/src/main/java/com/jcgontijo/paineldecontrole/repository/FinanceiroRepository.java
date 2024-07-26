package com.jcgontijo.paineldecontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcgontijo.paineldecontrole.model.Financeiro;

public interface FinanceiroRepository extends JpaRepository<Financeiro,Long>{
    
}
