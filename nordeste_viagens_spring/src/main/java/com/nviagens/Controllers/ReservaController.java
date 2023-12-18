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

import com.nviagens.Model.Reserva;
import com.nviagens.Repository.ReservaRepository;


@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reserva")
    public String mostrarFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva";
    }

    @PostMapping("/reserva")
    public String enviarReserva(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservausu/reservasucesso"; // Rota para página de sucesso de reserva
    }

    @GetMapping("/reservausu/reservasucesso") // Rota ajustada para o diretório reservausu
    public String reservaSucesso(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "reservausu/reservasucesso"; // HTML para a página de sucesso dentro de reservausu
    }
    
    
    //EDITAR
    @GetMapping("/editarres/{id}")
    public String mostrarPaginaEdicaoReserva(@PathVariable("id") Long id, Model model) {
        Reserva reserva = reservaRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("ID de reserva inválido: " + id));
        model.addAttribute("reserva", reserva);
        return "reservausu/editarres"; // HTML para o formulário de edição de reserva
    }

    @PostMapping("/reserva/atualizar/{id}")
    public String editarReserva(@PathVariable("id") Long id, @ModelAttribute("reserva") Reserva reservaDetails,
    		RedirectAttributes redirectAttributes) {
        Reserva reserva = reservaRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("ID de reserva inválido: " + id));
        reserva.setNome(reservaDetails.getNome());
        reserva.setTelefoneRes(reservaDetails.getTelefoneRes());
        reserva.setCpfRes(reservaDetails.getCpfRes());
        reserva.setCheckRes(reservaDetails.getCheckRes());
        reserva.setQuantidadePessoas(reservaDetails.getQuantidadePessoas());
        reserva.setDestinoRes(reservaDetails.getDestinoRes());
        reservaRepository.save(reserva);
        redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso!");
        return "redirect:/reservausu/reservasucesso";
    }

    @GetMapping("/excluirres/{id}")
    public String mostrarPaginaExclusao(@PathVariable ("id") Long id, Model model) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        model.addAttribute("reserva", reserva);
        return "reservausu/excluirres"; // Página de exclusão de usuário
    }
    
    @PostMapping("/excluirres/{id}")
    public String excluirReserva(@PathVariable ("id") Long id, RedirectAttributes redirectAttributes) {
        Reserva reserva = reservaRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("ID de reserva inválido: " + id));
        reservaRepository.delete(reserva);
        redirectAttributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
        return "redirect:/reservausu/reservasucesso";
    }
}