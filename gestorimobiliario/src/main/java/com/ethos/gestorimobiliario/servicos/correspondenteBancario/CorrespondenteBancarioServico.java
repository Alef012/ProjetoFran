package com.ethos.gestorimobiliario.servicos.correspondenteBancario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.CorrespondenteBancario;
import com.ethos.gestorimobiliario.repositorios.CorrespondenteBancarioRepositorio;
import com.ethos.gestorimobiliario.repositorios.EnderecoRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class CorrespondenteBancarioServico implements Servico<CorrespondenteBancario, Long, CorrespondenteBancario> {

    @Autowired
    private CorrespondenteBancarioRepositorio correspondenteBancarioRepositorio;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public CorrespondenteBancario criar(CorrespondenteBancario correspondenteBancario) {
        if (correspondenteBancario.getEndereco() != null) {
            enderecoRepositorio.save(correspondenteBancario.getEndereco());
        }

        return this.correspondenteBancarioRepositorio.save(correspondenteBancario);
    }

    @Override
    public CorrespondenteBancario obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.correspondenteBancarioRepositorio.findById(id).get();
    }

    @Override
    public List<CorrespondenteBancario> obterTodos() {
        return this.correspondenteBancarioRepositorio.findAll();
    }

    @Override
    public Page<CorrespondenteBancario> listarPaginado(Pageable pageable) {
        return this.correspondenteBancarioRepositorio.findAll(pageable);
    }

    @Override
    public CorrespondenteBancario atualizar(Long id, CorrespondenteBancario correspondenteBancarioAtualizado)
            throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        correspondenteBancarioAtualizado.setId(id);
        return this.criar(correspondenteBancarioAtualizado);

    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.correspondenteBancarioRepositorio.deleteById(id);

    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if (!correspondenteBancarioRepositorio.existsById(id)) {
            throw new EntidadeNaoEncontradaExcecao("Correspondente Bancário não encontrado com id: " + id);
        }
    }

}
