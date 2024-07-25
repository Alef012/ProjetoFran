package com.jcgontijo.paineldecontrole.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcgontijo.paineldecontrole.model.Usuario;
import com.jcgontijo.paineldecontrole.repository.UsuarioRepository;
import com.jcgontijo.paineldecontrole.service.UsuarioService;
import com.jcgontijo.paineldecontrole.util.AlterarSenha;
import com.jcgontijo.paineldecontrole.util.SenhaUtils;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @GetMapping("/perfil")
    public ModelAndView perfil(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("usuario/perfil");

        modelAndView.addObject("logado", this.usuarioService.encontrarPorEmail(principal.getName()).get());
        modelAndView.addObject("idUsuario", this.usuarioService.encontrarPorEmail(principal.getName()).get().getId());
        modelAndView.addObject("alterarSenhaForm", new AlterarSenha());

        return modelAndView;
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(AlterarSenha form, Principal principal) {
        Usuario usuario = usuarioRepository.findByEmail(principal.getName()).get();

        if (SenhaUtils.matches(form.getSenhaAtual(), usuario.getSenha())) {
            usuario.setSenha(SenhaUtils.encode(form.getNovaSenha()));

            usuarioRepository.save(usuario);
        }

        return "redirect:/perfil";

    }

}
