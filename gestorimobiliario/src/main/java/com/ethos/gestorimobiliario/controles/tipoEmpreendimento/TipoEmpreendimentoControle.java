package com.ethos.gestorimobiliario.controles.tipoEmpreendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethos.gestorimobiliario.controles.ControleAbstrato;
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.TipoEmpreendimento;
import com.ethos.gestorimobiliario.servicos.tipoEmpreendimento.TipoEmpreendimentoServico;

@RestController
@RequestMapping("/tipos-de-empreendimentos")
public class TipoEmpreendimentoControle extends ControleAbstrato<TipoEmpreendimento,Long,TipoEmpreendimento>{

    @Autowired
    private TipoEmpreendimentoServico tipoEmpreendimentoServico;

    @Override
    public ResponseEntity<TipoEmpreendimento> criar(TipoEmpreendimento tipoEmpreendimento) {
        return new ResponseEntity<TipoEmpreendimento>(tipoEmpreendimentoServico.criar(tipoEmpreendimento),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TipoEmpreendimento> editar(Long id, TipoEmpreendimento tipoEmpreendimento) {
        try{
            return new ResponseEntity<TipoEmpreendimento>(tipoEmpreendimentoServico.atualizar(id, tipoEmpreendimento),HttpStatus.OK);

        }catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<TipoEmpreendimento>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        try{
            tipoEmpreendimentoServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TipoEmpreendimento> obterPorId(Long id) {
        try{
            tipoEmpreendimentoServico.obterPorId(id);
            return new ResponseEntity<TipoEmpreendimento>(tipoEmpreendimentoServico.obterPorId(id),HttpStatus.OK);
        } catch(EntidadeNaoEncontradaExcecao e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<TipoEmpreendimento>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<Page<TipoEmpreendimento>>(this.tipoEmpreendimentoServico.listarPaginado(pageable),HttpStatus.OK);
    }
    
}
