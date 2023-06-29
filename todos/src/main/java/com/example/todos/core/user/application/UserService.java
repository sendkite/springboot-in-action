package com.example.todos.core.user.application;

import com.example.todos.core.user.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserPasswordVerifier, UserRegistration, ProfilePictureChanger {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User verify(String username, String rawPassword) throws UserPasswordNotMatchedException {
        return userRepository.findByUsername(username)
                             .orElseThrow(() -> new UserEntityNotFoundException(username))
                             .verifyPassword(passwordEncoder.encode(rawPassword));
    }

    @Override
    public User join(String username, String rawPassword) {
        return userRepository.findByUsername(username).orElseGet(() -> {
            User user = userRepository.save(new User(username, passwordEncoder.encode(rawPassword)));
            log.info("new user joining: {}", user);

            return user;
        });
    }

    @Override
    public User change(String username, ProfilePicture profilePicture) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserEntityNotFoundException(username))
                .changeProfilePicture(profilePicture);
    }
}
