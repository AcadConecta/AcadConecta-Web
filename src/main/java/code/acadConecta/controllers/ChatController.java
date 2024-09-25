package code.acadConecta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String loadChat() {
        return "chat";
    }

    @GetMapping("/editais")
    public String loadEdital() {
        return "components/editais";
    }

    @GetMapping("/vagas")
    public String loadVagas() {
        return "components/vagas";
    }

    @GetMapping("/chatCha")
    public String loadChatCha() {
        return "components/chatCha";
    }
}
