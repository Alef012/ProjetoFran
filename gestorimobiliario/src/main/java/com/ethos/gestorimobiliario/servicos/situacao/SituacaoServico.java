package com.ethos.gestorimobiliario.servicos.situacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Situacao;
import com.ethos.gestorimobiliario.repositorios.SituacaoRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class SituacaoServico implements Servico<Situacao,Long,Situacao>{
    
    @Autowired
    private SituacaoRepositorio situacaoRepositorio;

    @Override
    public Situacao criar(Situacao situacao) {
        return this.situacaoRepositorio.save(situacao);
    }

    @Override
    public Situacao obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.situacaoRepositorio.findById(id).get();
    }

    @Override
    public List<Situacao> obterTodos() {
        return this.situacaoRepositorio.findAll();
    }

    @Override
    public Page<Situacao> listarPaginado(Pageable pageable) {
        return this.situacaoRepositorio.findAll(pageable);
    }

    @Override
    public Situacao atualizar(Long id, Situacao situacaoAtualizada) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        situacaoAtualizada.setId(id);
        return this.criar(situacaoAtualizada);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        this.situacaoRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if(!situacaoRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Situacao não encontrado com id: "+id);
        }
    }
}
