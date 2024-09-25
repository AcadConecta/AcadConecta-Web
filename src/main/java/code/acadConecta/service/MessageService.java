package code.acadConecta.service;

import code.acadConecta.model.entities.Chanel;
import code.acadConecta.model.entities.Message;
import code.acadConecta.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    //salavando nova mensagem, no banco
    public void save(Message message) {
        messageRepository.save(message);
    }

    //realizando consulta pelo id do canal no qual a mesagem pertence
    public List<Message> findAllByChannel(Chanel chanel) {
       return messageRepository.findByIdChanel(chanel);
    }
}
