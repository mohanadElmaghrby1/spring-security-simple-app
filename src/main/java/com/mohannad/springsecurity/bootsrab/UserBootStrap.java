package com.mohannad.springsecurity.bootsrab;

import com.mohannad.springsecurity.model.User;
import com.mohannad.springsecurity.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
/**
 * created by mohannad
 * create user and store to DB
 */
@Component
public class UserBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    public UserBootStrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode("123456");
        System.out.println("pasword --------------------- ="+encodedPass);
        user.setPassword(encodedPass);
        user.setUsername("mohannad20");
        user.setEmail("mohannad.elmaghrby@gmail.com");

        userRepository.save(user);
        System.out.println("+++++++++++++++++++++++++++++save++++++++++++++++++++++++++");
    }
}
