package com.ethos.gestorimobiliario.controles.correspondenteBancario;

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
import com.ethos.gestorimobiliario.modelos.CorrespondenteBancario;
import com.ethos.gestorimobiliario.servicos.correspondenteBancario.CorrespondenteBancarioServico;

@RestController
@RequestMapping("/correspondentes-bancarios")
public class CorrespondenteBancarioControle extends ControleAbstrato<CorrespondenteBancario,Long,CorrespondenteBancario> {

    @Autowired
    private CorrespondenteBancarioServico correspondenteBancarioServico;

    @Override
    public ResponseEntity<CorrespondenteBancario> criar(@RequestBody CorrespondenteBancario correspondenteBancario) {
        return new ResponseEntity<CorrespondenteBancario>(this.correspondenteBancarioServico.criar(correspondenteBancario),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CorrespondenteBancario> editar(Long id, CorrespondenteBancario correspondenteBancario) {
        try {
            return new ResponseEntity<CorrespondenteBancario>(this.correspondenteBancarioServico.atualizar(id, correspondenteBancario),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try {
            correspondenteBancarioServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<CorrespondenteBancario> obterPorId(Long id) {
        try {
            return new ResponseEntity<CorrespondenteBancario>(this.correspondenteBancarioServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaExcecao e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<CorrespondenteBancario>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<CorrespondenteBancario>>(this.correspondenteBancarioServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
