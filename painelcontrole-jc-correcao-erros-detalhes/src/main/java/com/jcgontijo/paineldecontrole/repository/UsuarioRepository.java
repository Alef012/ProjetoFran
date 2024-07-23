package com.jcgontijo.paineldecontrole.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jcgontijo.paineldecontrole.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    List<Usuario> findByPerfil(String perfil);

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findAll(Pageable pageable);

     @Modifying
     @Transactional
     @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
     void deleteByIdCustom(@Param("id") Long id);

     @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = :email")
     boolean existePorEmail(String email);
}
