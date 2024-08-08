package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Financeiro;

@Repository
public interface FinanceiroRepositorio extends JpaRepository<Financeiro,Long>{
    
}
