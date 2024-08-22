package com.ethos.gestorimobiliario.servicos.equipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Equipe;
import com.ethos.gestorimobiliario.repositorios.EquipeRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class EquipeServico implements Servico<Equipe,Long,Equipe>{

    @Autowired
    private EquipeRepositorio equipeRepositorio;

    @Override
    public Equipe criar(Equipe equipe) {
        return this.equipeRepositorio.save(equipe);
    }

    @Override
    public Equipe obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.equipeRepositorio.findById(id).get();
    }

    @Override
    public List<Equipe> obterTodos() {
        return this.equipeRepositorio.findAll();
    }

    @Override
    public Page<Equipe> listarPaginado(Pageable pageable) {
        return this.equipeRepositorio.findAll(pageable);
    }

    @Override
    public Equipe atualizar(Long id, Equipe equipeAtualizada) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        equipeAtualizada.setId(id);
        return this.criar(equipeAtualizada);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.equipeRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!equipeRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Equipe não encontrada com id: "+id);
        }
    }
    
}
