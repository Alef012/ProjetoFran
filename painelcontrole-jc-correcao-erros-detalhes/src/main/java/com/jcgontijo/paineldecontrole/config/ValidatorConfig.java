package com.jcgontijo.paineldecontrole.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcgontijo.paineldecontrole.services.UsuarioService;
import com.jcgontijo.paineldecontrole.validators.UsuarioValidator;
@Configuration
public class ValidatorConfig {

   

    @Autowired
    private UsuarioService usuarioService;


    @Bean
    public UsuarioValidator usuarioValidator() {
        return new UsuarioValidator(usuarioService);
    }

   
}
