package code.acadConecta.service;

import code.acadConecta.model.entities.Chanel;
import code.acadConecta.repositories.ChanelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ChanelService {

    @Autowired
    private ChanelRepository chanelRepository;

    public Chanel findById(Long id) {
        Optional<Chanel> chanel = chanelRepository.findById(id);

        return chanel.orElse(null);
    }
}
