package com.nviagens.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nviagens.Model.FaleConosco;
import com.nviagens.Repository.FaleConoscoRepository;

@Controller
public class FaleConoscoController {

    @Autowired
    private FaleConoscoRepository faleConoscoRepository;
    
    /*
    // FAZER HTML PARA LISTAR MENSAGENS
  @GetMapping("/mensagens")
    public String listarMensagens(Model model) {
        List<FaleConosco> mensagens = faleConoscoRepository.findAll(); // Recupera todas as mensagens salvas
        model.addAttribute("mensagens", mensagens); // Adiciona à página para renderização
        return "lista_mensagens"; // Nome do arquivo HTML/Thymeleaf para listar as mensagens
    } */


    @GetMapping("/contato")
    public String showForm(Model model) {
        model.addAttribute("faleConosco", new FaleConosco());
        return "contato"; // Nome do arquivo HTML/Thymeleaf correspondente ao formulário
    }

    @PostMapping("/contato")
    public String submitForm(@ModelAttribute("faleConosco") FaleConosco faleConosco, RedirectAttributes redirectAttributes) {
        faleConoscoRepository.save(faleConosco);
        redirectAttributes.addFlashAttribute("mensagem2", "Enviado com sucesso!");
        return "redirect:/contato";
    }


}

