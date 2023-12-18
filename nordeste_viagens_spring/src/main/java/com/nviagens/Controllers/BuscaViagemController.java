package com.nviagens.Controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nviagens.Model.BuscaViagem;
import com.nviagens.Service.BuscaViagemService;

@Controller
public class BuscaViagemController {

    @Autowired
    private BuscaViagemService buscaViagemService;

    @PostMapping("/buscarViagem")
    public String buscarViagem(
            @RequestParam("destino") String destino,
            @RequestParam("preco") String preco,
            Model model
    ) {
        List<BuscaViagem> resultados;

        if (!destino.isEmpty() && !preco.isEmpty()) {
           
            resultados = buscaViagemService.buscarPorDestino(destino);
            resultados.retainAll(buscaViagemService.buscarPorPreco(preco));
        } else if (!destino.isEmpty()) {
          
            resultados = buscaViagemService.buscarPorDestino(destino);
        } else if (!preco.isEmpty()) {
           
            resultados = buscaViagemService.buscarPorPreco(preco);
        } else {
            
            resultados = Collections.emptyList();
        }

        model.addAttribute("resultados", resultados);
        return "resultados";
    }
}
