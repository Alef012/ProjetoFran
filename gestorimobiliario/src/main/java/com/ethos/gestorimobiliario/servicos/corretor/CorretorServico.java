package com.ethos.gestorimobiliario.servicos.corretor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Corretor;
import com.ethos.gestorimobiliario.repositorios.EnderecoRepositorio;
import com.ethos.gestorimobiliario.repositorios.corretorRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class CorretorServico implements Servico<Corretor,Long,Corretor>{

    @Autowired
    private corretorRepositorio corretorRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public Corretor criar(Corretor corretor) {
        if (corretor.getEndereco() != null) {
            this.enderecoRepositorio.save(corretor.getEndereco());
        }

        return this.corretorRepositorio.save(corretor);
    }

    @Override
    public Corretor obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.corretorRepositorio.findById(id).get();
    }

    @Override
    public List<Corretor> obterTodos() {
        return this.corretorRepositorio.findAll();
    }

    @Override
    public Page<Corretor> listarPaginado(Pageable pageable) {
        return this.corretorRepositorio.findAll(pageable);
    }

    @Override
    public Corretor atualizar(Long id, Corretor corretorAtualizado) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        corretorAtualizado.setId(id);
        return this.criar(corretorAtualizado);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.corretorRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if (!corretorRepositorio.existsById(id)) {
            throw new EntidadeNaoEncontradaExcecao("Financeiro não encontrado com id: " + id);
        }
    }
    
}
