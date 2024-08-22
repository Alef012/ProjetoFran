package com.ethos.gestorimobiliario.servicos.tipoEmpreendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.TipoEmpreendimento;
import com.ethos.gestorimobiliario.repositorios.TipoEmpreendimentoRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class TipoEmpreendimentoServico implements Servico<TipoEmpreendimento,Long,TipoEmpreendimento>{

    @Autowired
    private TipoEmpreendimentoRepositorio tipoEmpreendimentoRepositorio;
    
    @Override
    public TipoEmpreendimento criar(TipoEmpreendimento tipoEmpreendimento) {
        return this.tipoEmpreendimentoRepositorio.save(tipoEmpreendimento);
    }

    @Override
    public TipoEmpreendimento obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.tipoEmpreendimentoRepositorio.findById(id).get();

    }

    @Override
    public List<TipoEmpreendimento> obterTodos() {
        return this.tipoEmpreendimentoRepositorio.findAll();
    }

    @Override
    public Page<TipoEmpreendimento> listarPaginado(Pageable pageable) {
        return this.listarPaginado(pageable);
    }

    @Override
    public TipoEmpreendimento atualizar(Long id, TipoEmpreendimento tipoEmpreendimentoAtualizado) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        tipoEmpreendimentoAtualizado.setId(id);
        return this.criar(tipoEmpreendimentoAtualizado);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.tipoEmpreendimentoRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if(!tipoEmpreendimentoRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Tipo Empreendimento não encontrado com id: "+id);
        }
    }
    
}
