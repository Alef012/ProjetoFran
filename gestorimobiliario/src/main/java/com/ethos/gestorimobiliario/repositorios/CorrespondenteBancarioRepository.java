package com.ethos.gestorimobiliario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.CorrespondenteBancario;

@Repository
public interface CorrespondenteBancarioRepository extends JpaRepository<CorrespondenteBancario,Long>{
    
}
