package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente,Long>{
    
}
