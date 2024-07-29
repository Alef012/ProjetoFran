package com.ethos.gestorimobiliario.comandos;

import org.springframework.data.repository.CrudRepository;

public class DeletarComando<T, K> implements Comando<T> {

    private final CrudRepository<T, K> repositorio;
    private final K id;

    public DeletarComando(CrudRepository<T, K> repositorio, K id) {
        this.repositorio = repositorio;
        this.id = id;
    }

    @Override
    public T executar() {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return null;
        } else {
            throw new IllegalArgumentException("Entidade com ID " + id + " não encontrada");
        }
    }
}
