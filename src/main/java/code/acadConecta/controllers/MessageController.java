package code.acadConecta.controllers;

import code.acadConecta.model.entities.Chanel;
import code.acadConecta.model.entities.Message;
import code.acadConecta.model.entities.User;
import code.acadConecta.repositories.ChanelRepository;
import code.acadConecta.repositories.MessageRepository;
import code.acadConecta.repositories.UserRepository;
import code.acadConecta.service.ChanelService;
import code.acadConecta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ChanelService chanelService;

    @GetMapping("/showAllByChannel/{chanelNumber}")
    public String showMessage(Model model, @PathVariable Long chanelNumber) {
        System.out.println("VARIAVEL DO CANAL ====" + chanelNumber);

        List<Message> messages = messageRepository.findByIdChanel(chanelService.findById(chanelNumber));

        model.addAttribute("messages", messages);

        return "components/message";
    }
}
