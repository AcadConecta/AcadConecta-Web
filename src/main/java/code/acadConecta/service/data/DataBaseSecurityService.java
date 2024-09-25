package code.acadConecta.service.data;

import code.acadConecta.model.entities.User;
import code.acadConecta.model.util.HashItem;
import code.acadConecta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DataBaseSecurityService implements UserDetailsService {

    @Autowired
    private UserService userService;

    //retorna uma instância de userDetails, ou seja, as informações acerca do usuário que está tentando logar
    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            User user = userService.findById(HashItem.defineHash(username));

            Set<GrantedAuthority> authoritySet = new HashSet<>();

            //consultando e definindo as roles do usuário
            user.getRoles().forEach(role -> {
                authoritySet.add(new SimpleGrantedAuthority("ROLE_" + role));
            });

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authoritySet);

        } catch (UsernameNotFoundException error) {
            System.out.println("Error in loadChat user by name of database: " + error.getMessage());
        }

        return null;
    }
}
