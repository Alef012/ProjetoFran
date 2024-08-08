package com.ethos.gestorimobiliario.controles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class ControleAbstrato<T, K,A> implements Controle<T, K,A> {
    
    @PostMapping
    @Override
    public abstract ResponseEntity<T> criar(@RequestBody A entidade);

    @PutMapping("/{id}")
    @Override
    public abstract ResponseEntity<T> editar(@PathVariable K id, @RequestBody A entidade);

    @DeleteMapping("/{id}")
    @Override
    public abstract ResponseEntity<Void> deletar(@PathVariable K id);

    @GetMapping("/{id}")
    @Override
    public abstract ResponseEntity<T> obterPorId(@PathVariable K id);

    @GetMapping
    @Override
    public abstract ResponseEntity<Page<T>> listarPaginado(Pageable pageable);

}
