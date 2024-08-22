package com.ethos.gestorimobiliario.servicos.unidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Empreendimento;
import com.ethos.gestorimobiliario.modelos.Unidade;
import com.ethos.gestorimobiliario.modelos.adaptadores.UnidadeAdaptador;
import com.ethos.gestorimobiliario.repositorios.UnidadeRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;
import com.ethos.gestorimobiliario.servicos.empreendimento.EmpreendimentoServico;

@Service
public class UnidadeServico implements Servico<Unidade,Long,UnidadeAdaptador> {

    @Autowired
    private UnidadeRepositorio unidadeRepositorio;

    @Autowired
    private EmpreendimentoServico empreendimentoServico;

    @Override
    public Unidade criar(UnidadeAdaptador unidadeAdaptador) {
        Unidade unidade = new Unidade();
        try{
            Empreendimento empreendimento = empreendimentoServico.obterPorId(unidadeAdaptador.getEmpreendimentoId());
            unidade.setEmpreendimento(empreendimento);
            return this.unidadeRepositorio.save(unidade);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return null;
        }
    }

    @Override
    public Unidade obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.unidadeRepositorio.findById(id).get();
    }

    @Override
    public List<Unidade> obterTodos() {
        return this.unidadeRepositorio.findAll();
    }

    @Override
    public Page<Unidade> listarPaginado(Pageable pageable) {
        return this.unidadeRepositorio.findAll(pageable);
    }

    @Override
    public Unidade atualizar(Long id, UnidadeAdaptador unidadeAdaptador) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        unidadeAdaptador.getUnidade().setId(id);
        return this.criar(unidadeAdaptador);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        this.unidadeRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!unidadeRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Construtora não encontrada com id: "+id);
        }
    }
    
}
