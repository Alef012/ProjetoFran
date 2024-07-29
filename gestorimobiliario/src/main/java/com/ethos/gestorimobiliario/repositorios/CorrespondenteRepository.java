package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Correspondente;

@Repository
public interface CorrespondenteRepository extends JpaRepository<Correspondente,Long>{
    
}
