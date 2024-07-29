package com.ethos.gestorimobiliario.controles;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ethos.gestorimobiliario.comandos.Comando;
import com.ethos.gestorimobiliario.enumeradores.TipoComando;
import com.ethos.gestorimobiliario.fabricas.ComandoFabrica;
import com.ethos.gestorimobiliario.modelos.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteControle implements Controle<Cliente, Long> {

    private ComandoFabrica<Cliente, Long> comandoFabrica;

    @Autowired
    public ClienteControle(ComandoFabrica<Cliente, Long> comandoFabrica) {
        this.comandoFabrica = comandoFabrica;
    }

    @Override
    @PostMapping("/criar")
    public ResponseEntity<Cliente> criar(Cliente cliente) {
        Comando<Cliente> comando = comandoFabrica.criaComando(TipoComando.CRIAR, cliente, null);
        comando.executar();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(cliente.getId())
            .toUri();
        return ResponseEntity.created(location).body(cliente);
    }

    @Override
    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editar(Long id, Cliente cliente) {
        Comando<Cliente> comando = comandoFabrica.criaComando(TipoComando.EDITAR, cliente, id);
        comando.executar();
        return ResponseEntity.ok(cliente);
    }

    @Override
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(Long id) {
        Comando<Cliente> comando = comandoFabrica.criaComando(TipoComando.DELETAR, null, id);
        comando.executar();
        return ResponseEntity.noContent().build();
    }

}
