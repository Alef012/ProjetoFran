package com.ethos.gestorimobiliario.servicos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;

public interface Servico<T, ID,A> {
    T criar(A entidade);
    T obterPorId(ID id) throws EntidadeNaoEncontradaExcecao;
    List<T> obterTodos();
    Page<T> listarPaginado(Pageable pageable);
    T atualizar(ID id, A entidade) throws EntidadeNaoEncontradaExcecao;
    void deletar(ID id) throws EntidadeNaoEncontradaExcecao;
}
