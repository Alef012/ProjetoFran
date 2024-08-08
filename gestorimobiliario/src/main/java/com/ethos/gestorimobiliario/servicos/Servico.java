package com.ethos.gestorimobiliario.servicos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaException;

public interface Servico<T, ID> {
    T criar(T entidade);
    T obterPorId(ID id) throws EntidadeNaoEncontradaException;
    List<T> obterTodos();
    Page<T> listarPaginado(Pageable pageable);
    T atualizar(ID id, T entidade) throws EntidadeNaoEncontradaException;
    void deletar(ID id) throws EntidadeNaoEncontradaException;
}
