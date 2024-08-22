package com.ethos.gestorimobiliario.controles.unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Unidade;
import com.ethos.gestorimobiliario.modelos.adaptadores.UnidadeAdaptador;
import com.ethos.gestorimobiliario.servicos.unidade.UnidadeServico;


@RestController
@RequestMapping("/unidades")
public class UnidadeControle extends ControleAbstrato<Unidade,Long,UnidadeAdaptador>{

    @Autowired
    private UnidadeServico unidadeServico;
    @Override
    public ResponseEntity<Unidade> criar(@RequestBody UnidadeAdaptador unidadeAdaptador) {
        return new ResponseEntity<Unidade>(unidadeServico.criar(unidadeAdaptador),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Unidade> editar(Long id, UnidadeAdaptador entidade) {
        try {
            return new ResponseEntity<Unidade>(unidadeServico.atualizar(id, entidade),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try{
            unidadeServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Unidade> obterPorId(Long id) {
        try {
            return new ResponseEntity<Unidade>(unidadeServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Unidade>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Unidade>>(this.unidadeServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
