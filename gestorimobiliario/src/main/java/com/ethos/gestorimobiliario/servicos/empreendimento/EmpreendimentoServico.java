package com.ethos.gestorimobiliario.servicos.empreendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Construtora;
import com.ethos.gestorimobiliario.modelos.Empreendimento;
import com.ethos.gestorimobiliario.modelos.TipoEmpreendimento;
import com.ethos.gestorimobiliario.modelos.adaptadores.EmpreendimentoAdaptador;
import com.ethos.gestorimobiliario.repositorios.EmpreendimentoRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;
import com.ethos.gestorimobiliario.servicos.construtora.ConstrutoraServico;
import com.ethos.gestorimobiliario.servicos.tipoEmpreendimento.TipoEmpreendimentoServico;

@Service
public class EmpreendimentoServico implements Servico<Empreendimento,Long,EmpreendimentoAdaptador> {

    @Autowired
    private EmpreendimentoRepositorio empreendimentoRepositorio; 

    @Autowired
    private TipoEmpreendimentoServico tipoEmpreendimentoServico;

    @Autowired
    private ConstrutoraServico construtoraServico;

    @Override
    public Empreendimento criar(EmpreendimentoAdaptador empreendimentoAdaptador) {
        Empreendimento empreendimento = empreendimentoAdaptador.getEmpreendimento();
        try{
            TipoEmpreendimento tipoEmpreendimento = tipoEmpreendimentoServico.obterPorId(empreendimentoAdaptador.getTipoEmpreendimentoId());
            Construtora construtora = construtoraServico.obterPorId(empreendimentoAdaptador.getConstrutoraId());
            empreendimento.setConstrutora(construtora);
            empreendimento.setTipoEmpreendimento(tipoEmpreendimento);
            return this.empreendimentoRepositorio.save(empreendimento);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return null;
        }
    }

    @Override
    public Empreendimento obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.empreendimentoRepositorio.findById(id).get();
    }

    @Override
    public List<Empreendimento> obterTodos() {
        return this.empreendimentoRepositorio.findAll();
    }

    @Override
    public Page<Empreendimento> listarPaginado(Pageable pageable) {
        return this.empreendimentoRepositorio.findAll(pageable);
    }

    @Override
    public Empreendimento atualizar(Long id, EmpreendimentoAdaptador empreendimentoAdaptador) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        empreendimentoAdaptador.getEmpreendimento().setId(id);
        return this.criar(empreendimentoAdaptador);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        this.empreendimentoRepositorio.deleteById(id);
    }
    
    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!empreendimentoRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Empreendimento não encontrado com id: "+id);
        }
    }
}
