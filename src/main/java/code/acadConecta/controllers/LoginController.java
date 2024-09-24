package code.acadConecta.controllers;

import code.acadConecta.model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public void validateLogin(@ModelAttribute User user) {
        System.out.println(user);
    }
}


