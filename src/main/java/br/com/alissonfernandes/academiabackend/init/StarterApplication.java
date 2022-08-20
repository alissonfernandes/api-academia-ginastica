package br.com.alissonfernandes.academiabackend.init;

import br.com.alissonfernandes.academiabackend.model.security.User;
import br.com.alissonfernandes.academiabackend.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StarterApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if (user==null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("admin123");
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
        }

        User user2 = userRepository.findByUsername("user");
        if (user2==null) {
            user2 = new User();
            user2.setName("USER");
            user2.setUsername("user");
            user2.setPassword("user123");
            user2.getRoles().add("USERS");
            userRepository.save(user2);
        }
    }
}
