package code.acadConecta.controllers;

import code.acadConecta.model.entities.User;
import code.acadConecta.model.util.HashItem;
import code.acadConecta.model.util.ImageUtil;
import code.acadConecta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //atribuindo valor criptografado para email
        user.setEmail(HashItem.defineHash(user.getEmail()));

        //atribuindo um valor para imagem
        user.setImage(ImageUtil.generateBytesFromRelative());

        //atribuindo a role de USER para cada usuário cadastrado
        user.getRoles().add("USER");

        userService.save(user);

        return "redirect:/login";
    }
}
