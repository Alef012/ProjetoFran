package com.ethos.gestorimobiliario.servicos.gerente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Gerente;
import com.ethos.gestorimobiliario.repositorios.EnderecoRepositorio;
import com.ethos.gestorimobiliario.repositorios.GerenteRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class GerenteServico implements Servico<Gerente,Long,Gerente> {

    @Autowired
    private GerenteRepositorio gerenteRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public Gerente criar(Gerente gerente) {
        if(gerente.getEndereco()!=null){
            enderecoRepositorio.save(gerente.getEndereco());
        }

        return this.gerenteRepositorio.save(gerente);
    }

    @Override
    public Gerente obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.gerenteRepositorio.findById(id).get();
    }

    @Override
    public List<Gerente> obterTodos() {
        return this.gerenteRepositorio.findAll();
    }

    @Override
    public Page<Gerente> listarPaginado(Pageable pageable) {
        return this.gerenteRepositorio.findAll(pageable);
    }

    @Override
    public Gerente atualizar(Long id, Gerente gerenteAtualizado) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        gerenteAtualizado.setId(id);
        return this.criar(gerenteAtualizado);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.gerenteRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if(!gerenteRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Gerente não encontrado com id: "+id);
        }
    }
    
}
