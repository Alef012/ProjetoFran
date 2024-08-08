package com.ethos.gestorimobiliario.servicos.correspondente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Correspondente;
import com.ethos.gestorimobiliario.modelos.CorrespondenteBancario;
import com.ethos.gestorimobiliario.modelos.adaptadores.CorrespondenteAdaptador;
import com.ethos.gestorimobiliario.repositorios.CorrespondenteRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;
import com.ethos.gestorimobiliario.servicos.correspondenteBancario.CorrespondenteBancarioServico;

@Service
public class CorrespondenteServico implements Servico<Correspondente,Long,CorrespondenteAdaptador>{
    
    @Autowired
    private CorrespondenteRepositorio correspondenteRepositorio;

    @Autowired
    private CorrespondenteBancarioServico correspondenteBancarioServico;

    @Override
    public Correspondente criar(CorrespondenteAdaptador correspondenteAdaptador) {
        Correspondente correspondente = new Correspondente();
        correspondente.copiarAtributosDe(correspondenteAdaptador.getPessoa());
        try{
            CorrespondenteBancario correspondenteBancario = correspondenteBancarioServico.obterPorId(correspondenteAdaptador.getCorrespondenteBancarioId());
            correspondente.setCorrespondenteBancario(correspondenteBancario);
            return this.correspondenteRepositorio.save(correspondente);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return null;
        }
    }

    @Override
    public Correspondente obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.correspondenteRepositorio.findById(id).get();
    }

    @Override
    public List<Correspondente> obterTodos() {
        return this.correspondenteRepositorio.findAll();
    }

    @Override
    public Page<Correspondente> listarPaginado(Pageable pageable) {
        return this.correspondenteRepositorio.findAll(pageable);
    }

    @Override
    public Correspondente atualizar(Long id, CorrespondenteAdaptador correspondenteAdaptador) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        correspondenteAdaptador.getPessoa().setId(id);
        return this.criar(correspondenteAdaptador);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        correspondenteRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!correspondenteRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Correspondente não encontrada com id: "+id);
        }
    }

    
}
