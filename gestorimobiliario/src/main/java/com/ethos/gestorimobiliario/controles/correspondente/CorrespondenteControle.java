package com.ethos.gestorimobiliario.controles.correspondente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Correspondente;
import com.ethos.gestorimobiliario.modelos.adaptadores.CorrespondenteAdaptador;
import com.ethos.gestorimobiliario.servicos.correspondente.CorrespondenteServico;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/correspondentes")
public class CorrespondenteControle extends ControleAbstrato<Correspondente,Long,CorrespondenteAdaptador>{

    @Autowired
    private CorrespondenteServico correspondenteServico;

    @Override
    public ResponseEntity<Correspondente> criar(@RequestBody CorrespondenteAdaptador correspondenteAdaptador) {
        return new ResponseEntity<Correspondente>(this.correspondenteServico.criar(correspondenteAdaptador),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Correspondente> editar(@PathVariable Long id,@RequestBody CorrespondenteAdaptador correspondenteAdaptador) {
        try{
            return new ResponseEntity<Correspondente>(correspondenteServico.atualizar(id, correspondenteAdaptador),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            this.correspondenteServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Correspondente> obterPorId(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(this.correspondenteServico.obterPorId(id),HttpStatus.OK);
        }catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Correspondente>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<>(this.correspondenteServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
