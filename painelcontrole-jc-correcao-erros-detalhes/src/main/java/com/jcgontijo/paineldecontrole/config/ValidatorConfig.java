package com.jcgontijo.paineldecontrole.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcgontijo.paineldecontrole.service.UsuarioService;
import com.jcgontijo.paineldecontrole.validator.UsuarioValidator;
@Configuration
public class ValidatorConfig {

   

    @Autowired
    private UsuarioService usuarioService;


    @Bean
    public UsuarioValidator usuarioValidator() {
        return new UsuarioValidator(usuarioService);
    }

   
}
