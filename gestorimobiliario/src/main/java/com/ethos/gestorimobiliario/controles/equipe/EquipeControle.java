package com.ethos.gestorimobiliario.controles.equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Equipe;
import com.ethos.gestorimobiliario.servicos.equipe.EquipeServico;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/equipes")
public class EquipeControle extends ControleAbstrato<Equipe,Long,Equipe>{

    @Autowired
    private EquipeServico equipeServico;

    @Override
    public ResponseEntity<Equipe> criar(@RequestBody Equipe equipe) {
        return new ResponseEntity<Equipe>(this.equipeServico.criar(equipe),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Equipe> editar(Long id,@RequestBody Equipe equipe) {
        try {
            return new ResponseEntity<Equipe>(this.equipeServico.atualizar(id, equipe),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try {
            this.equipeServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Equipe> obterPorId(Long id) {
        try {
            return new ResponseEntity<Equipe>(this.equipeServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Equipe>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Equipe>>(this.equipeServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
