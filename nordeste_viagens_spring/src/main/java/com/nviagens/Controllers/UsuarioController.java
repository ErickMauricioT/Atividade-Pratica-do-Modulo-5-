package com.nviagens.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nviagens.Model.Usuario;
import com.nviagens.Repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuariocad/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuariocad/usuarios"; // Nome do arquivo HTML Thymeleaf
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarPaginaEdicao(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario", usuario);
        return "usuariocad/editar"; //edição de usuário dentro do diretório usuariocad
    }

    
    @PostMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable("id") Long id, 
                                   @ModelAttribute("usuario") Usuario usuarioAtualizado,
                                   RedirectAttributes redirectAttributes) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNameCad(usuarioAtualizado.getNameCad());
            usuarioExistente.setCpfCad(usuarioAtualizado.getCpfCad());
            usuarioExistente.setPhoneCad(usuarioAtualizado.getPhoneCad());
            usuarioExistente.setCepCad(usuarioAtualizado.getCepCad());
            usuarioExistente.setEndCad(usuarioAtualizado.getEndCad());
            usuarioExistente.setEmailCad(usuarioAtualizado.getEmailCad());
            usuarioExistente.setSenhaCad(usuarioAtualizado.getSenhaCad());
            usuarioRepository.save(usuarioExistente);
            redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso!");
        }
        return "redirect:/usuariocad/usuarios";
    }

    
    @GetMapping("/excluir/{id}")
    public String mostrarPaginaExclusao(@PathVariable ("id") Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario", usuario);
        return "usuariocad/excluir"; //exclusão de usuário
    }

    @PostMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        usuarioRepository.deleteById(id); // Excluir o usuário do banco de dados
        redirectAttributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
        return "redirect:/usuariocad/usuarios"; // Redirecionamento após exclusão
    }


}
