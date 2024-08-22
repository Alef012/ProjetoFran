package com.ethos.gestorimobiliario.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ethos.gestorimobiliario.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
    List<Usuario> findByPerfil(String perfil);

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findAll(Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = :email")
    boolean existePorEmail(String email);
}
