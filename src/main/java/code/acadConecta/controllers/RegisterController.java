package code.acadConecta.controllers;

import code.acadConecta.model.entities.User;
import code.acadConecta.model.util.HashItem;
import code.acadConecta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String testSave() {

        User user = new User(HashItem.defineHash("maria@gmail.com"), "maria", HashItem.defineHash("1234"), null, null);

        userService.save(user);

        /*
        * validar campos, validar tamanho, adicionar roles: USER, ADMIN
        * */

        return "redirect:/login";
    }
}
