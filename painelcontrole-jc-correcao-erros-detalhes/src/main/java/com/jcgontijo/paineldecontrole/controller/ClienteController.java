package com.jcgontijo.paineldecontrole.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcgontijo.paineldecontrole.model.Cliente;
import com.jcgontijo.paineldecontrole.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ModelAndView listar(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("cliente/lista");

        Page<Cliente> paginaDeClientes = this.clienteService.listar(pageable);

        modelAndView.addObject("clientes", paginaDeClientes);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
         ModelAndView modelAndView = new ModelAndView("cliente/formulario");
         modelAndView.addObject("cliente", new Cliente());

         return modelAndView;
    }


    @PostMapping("/cadastrar")
    public String cadastrar(Cliente cliente,ModelMap modelMap,RedirectAttributes attrs,BindingResult bindingResult) throws IllegalAccessException, InvocationTargetException{
        if(bindingResult.hasErrors()){
            modelMap.addAttribute("cliente",cliente);
        }
        if(cliente.getId()==null){
            clienteService.cadastrar(cliente);
        } else{
            clienteService.atualizar(cliente, cliente.getId());
        }

        return "redirect:/clientes/listar";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/formulario");

        modelAndView.addObject("cliente",clienteService.buscarPorId(id));

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        clienteService.excluirPorId(id);
        return "redirect:/clientes/listar";
    }
   
    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/detalhes");

        modelAndView.addObject("cliente", clienteService.buscarPorId(id));

        return modelAndView;
    }
}
