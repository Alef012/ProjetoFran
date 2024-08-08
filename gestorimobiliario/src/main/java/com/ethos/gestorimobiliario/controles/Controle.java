package com.ethos.gestorimobiliario.controles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface Controle<T,K,A> {
    ResponseEntity<T> criar(A entidade);

    ResponseEntity<T> editar(K id,A entidade);

    ResponseEntity<Void> deletar(K id);

    ResponseEntity<T> obterPorId(K id);

    ResponseEntity<Page<T>> listarPaginado(Pageable pageable);
}
