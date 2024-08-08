package com.ethos.gestorimobiliario.controles.cliente;

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
import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaException;
import com.ethos.gestorimobiliario.modelos.Cliente;
import com.ethos.gestorimobiliario.servicos.cliente.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteControle extends ControleAbstrato<Cliente, Long> {
    @Autowired
    private ClienteServico clienteServico;

    @Override
    public ResponseEntity<Cliente> criar(@RequestBody Cliente entidade) {
        return new ResponseEntity<Cliente>(clienteServico.criar(entidade), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Cliente> editar(@PathVariable Long id,@RequestBody Cliente entidade) {
        try {
            return new ResponseEntity<Cliente>(clienteServico.atualizar(id, entidade), HttpStatus.OK);
        } catch (EntidadeNaoEncontradaException excecao) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            clienteServico.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntidadeNaoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Cliente> obterPorId(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(clienteServico.obterPorId(id),HttpStatus.OK);
        } catch (EntidadeNaoEncontradaException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Page<Cliente>> listarPaginado(Pageable pageable) {
        return new ResponseEntity<>(this.clienteServico.listarPaginado(pageable), HttpStatus.OK);
    }
}
