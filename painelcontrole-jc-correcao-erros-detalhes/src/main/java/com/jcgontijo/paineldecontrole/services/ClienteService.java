package com.jcgontijo.paineldecontrole.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jcgontijo.paineldecontrole.model.Cliente;
import com.jcgontijo.paineldecontrole.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente cadastrar  (Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente atualizar(Cliente cliente, Long id) throws IllegalAccessException, InvocationTargetException{
        Cliente antigo = clienteRepository.findById(id).get();

        BeanUtils.copyProperties(antigo, cliente);
        antigo.setId(id);

        return antigo;
    }

    public void excluirPorId(Long id){
        Cliente antigo = clienteRepository.findById(id).get();

        clienteRepository.delete(antigo);
    }

    public Page<Cliente> listar(Pageable pageable){
        return this.clienteRepository.findAll(pageable);
    }

    
    
}
