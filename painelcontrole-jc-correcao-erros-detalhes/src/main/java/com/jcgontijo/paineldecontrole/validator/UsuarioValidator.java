package com.jcgontijo.paineldecontrole.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jcgontijo.paineldecontrole.model.Usuario;
import com.jcgontijo.paineldecontrole.service.UsuarioService;

public class UsuarioValidator implements Validator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d@#$%^&+=]{5,}$";

    private final UsuarioService usuarioService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    public UsuarioValidator(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "NotEmpty");
        if (usuario.getNome().length() < 3) {
            errors.rejectValue("nome", "Size.usuario.nome.min");
        } else if (usuario.getNome().length() > 80) {
            errors.rejectValue("nome", "Size.usuario.nome.max");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!usuario.getEmail().matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
            errors.rejectValue("email", "Invalid.usuario.email");
        }

        if (usuarioService.existePorEmail(usuario.getEmail()) && usuario.getId() == null) {
            errors.rejectValue("email", "Unique.usuario.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "perfil", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "NotEmpty");
        if (!Pattern.matches(PASSWORD_PATTERN, usuario.getSenha())) {
            errors.rejectValue("senha", "Pattern.usuario.senha");
        }
    }

}
