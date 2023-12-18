package com.nviagens.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nviagens.Model.Usuario;
import com.nviagens.Repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    private final UsuarioRepository usuarioRepository;

    public CadastroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String mostrarFormulario() {
        return "cadastro"; // Retorna o nome do arquivo HTML/Thymeleaf do formulário de cadastro
    }

    @PostMapping
    public String cadastrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario); // Salva o usuário no banco de dados
        return "redirect:usuariocad/usuarios"; // Redireciona após o cadastro
    }
}

