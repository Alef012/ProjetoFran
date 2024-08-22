package com.ethos.gestorimobiliario.controles.situacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Situacao;
import com.ethos.gestorimobiliario.servicos.situacao.SituacaoServico;

@RestController
@RequestMapping("/situacoes")
public class SituacaoControle extends ControleAbstrato<Situacao,Long,Situacao> {

    @Autowired
    private SituacaoServico situacaoServico;

    @Override
    public ResponseEntity<Situacao> criar(Situacao situacao) {
        return new ResponseEntity<Situacao>(this.situacaoServico.criar(situacao),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Situacao> editar(Long id, Situacao entidade) {
        try {
            return new ResponseEntity<Situacao>(this.situacaoServico.atualizar(id, entidade),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try {
            this.situacaoServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public ResponseEntity<Situacao> obterPorId(Long id) {
        try {
            return new ResponseEntity<Situacao>(this.situacaoServico.obterPorId(id),HttpStatus.OK);
            
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Situacao>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Situacao>>(this.situacaoServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
