package com.ethos.gestorimobiliario.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ethos.gestorimobiliario.servicos.UsuarioService;
import com.ethos.gestorimobiliario.validadores.UsuarioValidator;
@Configuration
public class ValidatorConfig {

   

    @Autowired
    private UsuarioService usuarioService;


    @Bean
    public UsuarioValidator usuarioValidator() {
        return new UsuarioValidator(usuarioService);
    }

   
}
