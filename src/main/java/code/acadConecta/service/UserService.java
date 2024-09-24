package code.acadConecta.service;

import code.acadConecta.model.entities.User;
import code.acadConecta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(String userEmail) {
        Optional<User> user = userRepository.findById(userEmail);

        return user.orElse(null);
    }

    public void save(User user) {
        //logica de cripto
        userRepository.save(user);
    }
}
