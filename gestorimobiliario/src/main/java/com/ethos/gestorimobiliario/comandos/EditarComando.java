package com.ethos.gestorimobiliario.comandos;

import org.springframework.data.repository.CrudRepository;

public class EditarComando <T, K> implements Comando<T> {

    private final CrudRepository<T, K> repositorio;
    private final T entidade;
    private final K id;

    public EditarComando(CrudRepository<T, K> repositorio, T entidade, K id) {
        this.repositorio = repositorio;
        this.entidade = entidade;
        this.id = id;
    }

    @Override
    public T executar() {
        if (repositorio.existsById(id)) {
            return repositorio.save(entidade);
        } else {
            throw new IllegalArgumentException("Entidade com ID " + id + " não encontrada");
        }
    }
}
