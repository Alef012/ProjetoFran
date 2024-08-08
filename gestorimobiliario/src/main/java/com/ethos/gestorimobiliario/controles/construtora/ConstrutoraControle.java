package com.ethos.gestorimobiliario.controles.construtora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Construtora;
import com.ethos.gestorimobiliario.modelos.adaptadores.ConstrutoraAdaptador;
import com.ethos.gestorimobiliario.servicos.construtora.ConstrutoraServico;

@RestController
@RequestMapping("/construtoras")
public class ConstrutoraControle extends ControleAbstrato<Construtora,Long,ConstrutoraAdaptador>{
    
    @Autowired
    private ConstrutoraServico construtoraServico;

    @Override
    public ResponseEntity<Construtora> criar(@RequestBody ConstrutoraAdaptador construtoraAdaptador) {
        return new ResponseEntity<Construtora>(this.construtoraServico.criar(construtoraAdaptador),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Construtora> editar(Long id,@RequestBody ConstrutoraAdaptador construtoraAdaptador) {
        try{
            return new ResponseEntity<Construtora>(construtoraServico.atualizar(id, construtoraAdaptador),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            construtoraServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Construtora> obterPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.construtoraServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Construtora>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<>(this.construtoraServico.listarPaginado(pageable),HttpStatus.OK);
    }

    
}
