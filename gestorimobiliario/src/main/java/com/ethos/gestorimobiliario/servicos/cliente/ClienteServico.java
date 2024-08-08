package com.ethos.gestorimobiliario.servicos.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.modelos.Cliente;
import com.ethos.gestorimobiliario.repositorios.ClienteRepositorio;
import com.ethos.gestorimobiliario.repositorios.EnderecoRepositorio;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class ClienteServico implements Servico<Cliente,Long,Cliente> {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Override
    public Cliente criar(Cliente cliente) {
        if(cliente.getEndereco()!=null){
            this.enderecoRepositorio.save(cliente.getEndereco());
        }

        return this.clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
       this.verificarExistenciaPorId(id);
       return this.clienteRepositorio.findById(id).get();
    }

    @Override
    public List<Cliente> obterTodos() {
        return this.clienteRepositorio.findAll();
    }

    @Override
    public Page<Cliente> listarPaginado(Pageable pageable) {
        return this.clienteRepositorio.findAll(pageable);
    }

    @Override
    public Cliente atualizar(Long id, Cliente clienteAtualizado) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        clienteAtualizado.setId(id);
        return this.criar(clienteAtualizado);
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        verificarExistenciaPorId(id);
        this.clienteRepositorio.deleteById(id);
    }

    private void verificarExistenciaPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        if (!clienteRepositorio.existsById(id)) {
            throw new EntidadeNaoEncontradaExcecao("Cliente não encontrado com id: " + id);
        }
    }
    
}
