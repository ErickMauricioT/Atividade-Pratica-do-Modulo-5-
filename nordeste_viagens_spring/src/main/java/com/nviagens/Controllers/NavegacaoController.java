package com.nviagens.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoController {

	 // Retorna o nome do arquivo HTML para a página inicial
	
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/destinos")
    public String destinos() {
        return "destinos"; 
    }

    @GetMapping("/promocoes")
    public String promocoes() {
        return "promocoes"; 
    }

    @GetMapping("/login")
    public String login() {
        return "login"; 

   /* @GetMapping("/reserva")
    public String reserva() {
        return "reserva"; 
    }*/

}
   }
