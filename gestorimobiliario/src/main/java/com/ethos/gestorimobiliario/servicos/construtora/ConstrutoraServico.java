package com.ethos.gestorimobiliario.servicos.construtora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Construtora;
import com.ethos.gestorimobiliario.modelos.Financeiro;
import com.ethos.gestorimobiliario.modelos.Gerente;
import com.ethos.gestorimobiliario.modelos.adaptadores.ConstrutoraAdaptador;
import com.ethos.gestorimobiliario.repositorios.ConstrutoraRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;
import com.ethos.gestorimobiliario.servicos.financeiro.FinanceiroServico;
import com.ethos.gestorimobiliario.servicos.gerente.GerenteServico;

@Service
public class ConstrutoraServico implements Servico<Construtora,Long,ConstrutoraAdaptador> {

    @Autowired
    private ConstrutoraRepositorio construtoraRepositorio;

    @Autowired
    private FinanceiroServico financeiroServico;

    @Autowired
    private GerenteServico gerenteServico;

    @Override
    public Construtora criar(ConstrutoraAdaptador construtoraAdaptador) {
        Construtora construtora = new Construtora();
        construtora.copiarAtributosDe(construtoraAdaptador.getPessoaJuridica());
        try{
            Gerente gerente = this.gerenteServico.obterPorId(construtoraAdaptador.getGerenteId());
            Financeiro financeiro = this.financeiroServico.obterPorId(construtoraAdaptador.getFinanceiroId());
            construtora.setFinanceiro(financeiro);
            construtora.setGerente(gerente);
            return this.construtoraRepositorio.save(construtora);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return null;
        }

    }

    @Override
    public Construtora obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.construtoraRepositorio.findById(id).get();
    }

    @Override
    public List<Construtora> obterTodos() {
        return this.construtoraRepositorio.findAll();
    }

    @Override
    public Page<Construtora> listarPaginado(Pageable pageable) {
        return this.construtoraRepositorio.findAll(pageable);
    }

    @Override
    public Construtora atualizar(Long id, ConstrutoraAdaptador construtoraAdaptador) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        construtoraAdaptador.getPessoaJuridica().setId(id);
        return this.criar(construtoraAdaptador);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        this.construtoraRepositorio.deleteById(id);;
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!construtoraRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Construtora não encontrada com id: "+id);
        }
    }
    
}
