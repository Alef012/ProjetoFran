package com.ethos.gestorimobiliario.servicos.financeiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Financeiro;
import com.ethos.gestorimobiliario.repositorios.EnderecoRepositorio;
import com.ethos.gestorimobiliario.repositorios.FinanceiroRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class FinanceiroServico implements Servico<Financeiro, Long,Financeiro> {

    @Autowired
    private FinanceiroRepositorio financeiroRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public Financeiro criar(Financeiro financeiro) {
        if (financeiro.getEndereco() != null) {
            this.enderecoRepositorio.save(financeiro.getEndereco());
        }

        return this.financeiroRepositorio.save(financeiro);
    }

    @Override
    public Financeiro obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.financeiroRepositorio.findById(id).get();
    }

    @Override
    public List<Financeiro> obterTodos() {
        return this.financeiroRepositorio.findAll();
    }

    @Override
    public Page<Financeiro> listarPaginado(Pageable pageable) {
        return this.financeiroRepositorio.findAll(pageable);
    }

    @Override
    public Financeiro atualizar(Long id, Financeiro financeiroAtualizado) throws EntidadeNaoEncontradaExcecao {
       verificarExistenciaPorId(id);
       financeiroAtualizado.setId(id);
       return this.criar(financeiroAtualizado);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
       verificarExistenciaPorId(id);
       this.financeiroRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if (!financeiroRepositorio.existsById(id)) {
            throw new EntidadeNaoEncontradaExcecao("Financeiro não encontrado com id: " + id);
        }
    }

}
