package com.ethos.gestorimobiliario.controles.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Proposta;
import com.ethos.gestorimobiliario.modelos.adaptadores.PropostaAdaptador;
import com.ethos.gestorimobiliario.servicos.proposta.PropostaServico;

@RestController
@RequestMapping("/propostas")
public class PropostaControle extends ControleAbstrato<Proposta,Long,PropostaAdaptador>{

    @Autowired
    private PropostaServico propostaServico;

    @Override
    public ResponseEntity<Proposta> criar(PropostaAdaptador propostaAdaptador) {
        return new ResponseEntity<Proposta>(this.propostaServico.criar(propostaAdaptador),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Proposta> editar(Long id, PropostaAdaptador entidade) {
        try{
           return new ResponseEntity<Proposta>(propostaServico.atualizar(id, entidade),HttpStatus.OK) ;
        }catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try{
            propostaServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Proposta> obterPorId(Long id) {
        try{
            return new ResponseEntity<Proposta>(propostaServico.obterPorId(id),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Proposta>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Proposta>>(this.propostaServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
