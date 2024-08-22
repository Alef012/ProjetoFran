package com.ethos.gestorimobiliario.controles.empreendimento;

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
import com.ethos.gestorimobiliario.modelos.Empreendimento;
import com.ethos.gestorimobiliario.modelos.adaptadores.EmpreendimentoAdaptador;
import com.ethos.gestorimobiliario.servicos.empreendimento.EmpreendimentoServico;

@RestController
@RequestMapping("/empreendimentos")
public class EmpreendimentoControle extends ControleAbstrato<Empreendimento,Long,EmpreendimentoAdaptador>{

    @Autowired
    private EmpreendimentoServico empreendimentoServico;

    @Override
    public ResponseEntity<Empreendimento> criar(@RequestBody EmpreendimentoAdaptador empreendimentoAdaptador) {
        return new ResponseEntity<Empreendimento>(this.empreendimentoServico.criar(empreendimentoAdaptador),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Empreendimento> editar(Long id, EmpreendimentoAdaptador empreendimentoAdaptador) {
        try{
            return new ResponseEntity<Empreendimento>(empreendimentoServico.atualizar(id,empreendimentoAdaptador),HttpStatus.OK);
        }catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try{
            empreendimentoServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Empreendimento> obterPorId(Long id) {
        try{
            return new ResponseEntity<Empreendimento>(empreendimentoServico.obterPorId(id),HttpStatus.OK);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Empreendimento>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<Empreendimento>>(this.empreendimentoServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
