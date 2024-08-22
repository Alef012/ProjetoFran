package com.ethos.gestorimobiliario.controles.financeiro;

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
import com.ethos.gestorimobiliario.modelos.Financeiro;
import com.ethos.gestorimobiliario.servicos.financeiro.FinanceiroServico;


@RestController
@RequestMapping("/financeiros")
public class FinanceiroControle extends ControleAbstrato<Financeiro,Long,Financeiro> {
    
    @Autowired
    private FinanceiroServico financeiroServico;

    @Override
    public ResponseEntity<Financeiro> criar(@RequestBody Financeiro financeiro) {
       return new ResponseEntity<Financeiro>(this.financeiroServico.criar(financeiro),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Financeiro> editar(@PathVariable Long id,@RequestBody Financeiro financeiro) {
        try{
            return new ResponseEntity<Financeiro>(financeiroServico.atualizar(id,financeiro),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try{
            financeiroServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Financeiro> obterPorId(@PathVariable Long id) {
        try{
            return new ResponseEntity<Financeiro>(financeiroServico.obterPorId(id),HttpStatus.OK);
        } catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Financeiro>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Financeiro>>(this.financeiroServico.listarPaginado(pageable),HttpStatus.OK);
    }


}
