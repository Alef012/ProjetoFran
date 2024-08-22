package com.ethos.gestorimobiliario.servicos.proposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Cliente;
import com.ethos.gestorimobiliario.modelos.CorrespondenteBancario;
import com.ethos.gestorimobiliario.modelos.Corretor;
import com.ethos.gestorimobiliario.modelos.Proposta;
import com.ethos.gestorimobiliario.modelos.Situacao;
import com.ethos.gestorimobiliario.modelos.Unidade;
import com.ethos.gestorimobiliario.modelos.adaptadores.PropostaAdaptador;
import com.ethos.gestorimobiliario.repositorios.PropostaRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;
import com.ethos.gestorimobiliario.servicos.cliente.ClienteServico;
import com.ethos.gestorimobiliario.servicos.correspondenteBancario.CorrespondenteBancarioServico;
import com.ethos.gestorimobiliario.servicos.corretor.CorretorServico;
import com.ethos.gestorimobiliario.servicos.situacao.SituacaoServico;
import com.ethos.gestorimobiliario.servicos.unidade.UnidadeServico;

@Service
public class PropostaServico implements Servico<Proposta,Long,PropostaAdaptador>{

    @Autowired
    private PropostaRepositorio propostaRepositorio;

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private CorretorServico corretorServico;

    @Autowired 
    private UnidadeServico unidadeServico;

    @Autowired
    private SituacaoServico situacaoServico;

    @Autowired
    private CorrespondenteBancarioServico correspondenteBancarioServico;

    @Override
    public Proposta criar(PropostaAdaptador propostaAdapatador) {
        Proposta proposta = propostaAdapatador.getProposta();
        try {
            Cliente cliente = this.clienteServico.obterPorId(propostaAdapatador.getClienteId());
            Corretor corretor = this.corretorServico.obterPorId(propostaAdapatador.getCorretorId());
            Unidade unidade = this.unidadeServico.obterPorId(propostaAdapatador.getUnidadeId());
            Situacao situacao = this.situacaoServico.obterPorId(propostaAdapatador.getSituacaoId());
            CorrespondenteBancario correspondenteBancario = this.correspondenteBancarioServico.obterPorId(propostaAdapatador.getCorrespondenteBancarioId());

            proposta.setCliente(cliente);
            proposta.setCorretor(corretor);
            proposta.setUnidade(unidade);
            proposta.setSituacao(situacao);
            proposta.setCorrespondenteBancario(correspondenteBancario);
            return this.propostaRepositorio.save(proposta);

            
        } catch (EntidadeNaoEncontradaExcecao e) {
            return null;
        }
    }

    @Override
    public Proposta obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        return this.propostaRepositorio.findById(id).get();
    }

    @Override
    public List<Proposta> obterTodos() {
        return this.propostaRepositorio.findAll();
    }

    @Override
    public Page<Proposta> listarPaginado(Pageable pageable) {
        return this.propostaRepositorio.findAll(pageable);
    }

    @Override
    public Proposta atualizar(Long id, PropostaAdaptador propostaAdapatador) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        propostaAdapatador.getProposta().setId(id);
        return this.criar(propostaAdapatador);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        this.verificarExistenciaPorId(id);
        this.propostaRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao{
        if(!propostaRepositorio.existsById(id)){
            throw new EntidadeNaoEncontradaExcecao("Proposta não encontrada com id: "+id);
        }
    }
    
}
