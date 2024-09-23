package code.acadConecta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/index")
    public String home() {
        return "index"; // Retorna o nome do arquivo HTML (index.html) que estará na pasta templates
    }
}


