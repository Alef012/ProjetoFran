package com.ethos.gestorimobiliario.comandos;

import org.springframework.data.repository.CrudRepository;

public class CriarComando <T> implements Comando<T> {

    private final CrudRepository<T, ?> repositorio;
    private final T entidade;

    public CriarComando(CrudRepository<T, ?> repositorio, T entidade) {
        this.repositorio = repositorio;
        this.entidade = entidade;
    }

    @Override
    public T executar() {
        return repositorio.save(entidade);
    }
}
