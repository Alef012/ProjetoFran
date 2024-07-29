package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Origem;

@Repository
public interface OrigemRepository extends JpaRepository<Origem,Long>{
    
}
