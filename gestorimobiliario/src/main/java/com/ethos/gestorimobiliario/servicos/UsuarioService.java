package com.ethos.gestorimobiliario.servicos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

import com.ethos.gestorimobiliario.modelos.Usuario;
import com.ethos.gestorimobiliario.repositorios.UsuarioRepositorio;
import com.ethos.gestorimobiliario.util.SenhaUtils;

import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Value("${diretorio.usuarios}")
    private String diretorio;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setAtivo(true);
        usuario.setSenha(SenhaUtils.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        usuario.setAtivo(true);
        usuario.setSenha(SenhaUtils.encode(usuario.getSenha()));
        if(usuario.getFotoPerfilPath() == null || usuario.getFotoPerfilPath().isEmpty()) {
            usuario.setFotoPerfilPath(this.getPathFotoPerfil(id));
        }
        return usuarioRepository.save(usuario);
    }

    public void excluirPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> encontrarPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }

    public Page<Usuario> listar(Pageable pageable) {
        return this.usuarioRepository.findAll(pageable);
    }

    public List<String> listarTiposDeUsuarios() {
        return Arrays.asList("Administrador", "Juridico", "Qualidade", "Comercial");
    }

    public String salvarFotoDePerfil(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }

        Path directory = Paths.get(diretorio);

        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        String originalFilename = file.getOriginalFilename();
        String filenameWithoutExtension = FilenameUtils.removeExtension(originalFilename);
        String extension = FilenameUtils.getExtension(originalFilename);

        String newFileName = filenameWithoutExtension + "_" + System.currentTimeMillis() + "." + extension;

        Path filePath = Paths.get(diretorio + "/" + newFileName);

        Files.write(filePath, file.getBytes());

        return filePath.toString();
    }

    public String getPathFotoPerfil(Long id) {
        Usuario usuario = this.buscarPorId(id);
        return usuario.getFotoPerfilPath();
    }

    public Boolean ativarOuDesativar(Long id) {
        Usuario usuario = this.buscarPorId(id);
        usuario.setAtivo(!usuario.getAtivo());
        this.usuarioRepository.save(usuario);
        return usuario.getAtivo();
    }

    public boolean existePorEmail(String email) {
        return usuarioRepository.existePorEmail(email);
    }


    


}
