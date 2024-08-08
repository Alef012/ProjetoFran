package com.ethos.gestorimobiliario.controles.corretor;

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
import com.ethos.gestorimobiliario.modelos.Corretor;
import com.ethos.gestorimobiliario.servicos.corretor.CorretorServico;


@RestController
@RequestMapping("/corretores")
public class CorretorControle extends ControleAbstrato<Corretor,Long,Corretor>{

    @Autowired
    private CorretorServico corretorServico;

    @Override
    public ResponseEntity<Corretor> criar(@RequestBody Corretor corretor) {
        return new ResponseEntity<Corretor>(this.corretorServico.criar(corretor),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Corretor> editar(@PathVariable Long id,@RequestBody Corretor entidade) {
        try{
            return new ResponseEntity<Corretor>(corretorServico.atualizar(id, entidade),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try{
            corretorServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Corretor> obterPorId(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(this.corretorServico.obterPorId(id),HttpStatus.OK);
        }catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Corretor>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<>(this.corretorServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
