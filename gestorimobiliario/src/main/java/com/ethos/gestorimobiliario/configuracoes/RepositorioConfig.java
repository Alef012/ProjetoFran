package com.ethos.gestorimobiliario.configuracoes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.ethos.gestorimobiliario.modelos.Cliente;
import com.ethos.gestorimobiliario.repositorios.ClienteRepositorio;

@Configuration
public class RepositorioConfig {
    
    @Bean
    public Map<Class<?>, CrudRepository<?, ?>> repositorios(
            ClienteRepositorio clienteRepositorio) {
        Map<Class<?>, CrudRepository<?, ?>> map = new HashMap<>();
        map.put(Cliente.class, clienteRepositorio);
        return map;
    }
}
