package com.example.todos.core.user.application;

import com.example.todos.core.user.domain.PasswordEncoder;
import com.example.todos.core.user.domain.User;
import com.example.todos.core.user.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User join(String username, String rawPassword) {
        return userRepository.findByUsername(username).orElseGet(() -> {
            User user = userRepository.save(new User(username, passwordEncoder.encode(rawPassword)));
            log.info("new user joining: {}", user);

            return user;
        });
    }


}
