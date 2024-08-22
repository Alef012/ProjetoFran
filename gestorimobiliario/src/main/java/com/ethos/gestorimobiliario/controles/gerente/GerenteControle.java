package com.ethos.gestorimobiliario.controles.gerente;

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
import com.ethos.gestorimobiliario.modelos.Gerente;
import com.ethos.gestorimobiliario.servicos.gerente.GerenteServico;

@RestController
@RequestMapping("/gerentes")
public class GerenteControle extends ControleAbstrato<Gerente,Long,Gerente>{

    @Autowired
    private GerenteServico gerenteServico;

    @Override
    public ResponseEntity<Gerente> criar(@RequestBody Gerente gerente) {
        return new ResponseEntity<Gerente>(gerenteServico.criar(gerente),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Gerente> editar(Long id, Gerente gerente) {
        try{
            return new ResponseEntity<Gerente>(gerenteServico.atualizar(id, gerente),HttpStatus.OK);
        } catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try{
            gerenteServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Gerente> obterPorId(Long id) {
        try{
            return new ResponseEntity<Gerente>(gerenteServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Gerente>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Gerente>>(this.gerenteServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
