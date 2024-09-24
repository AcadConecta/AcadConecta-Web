package code.acadConecta.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @GetMapping("/teste")
    public String load(Model model) {
        model.addAttribute("teste", SecurityContextHolder.getContext().getAuthentication().getName());

        return "teste";
    }
}
