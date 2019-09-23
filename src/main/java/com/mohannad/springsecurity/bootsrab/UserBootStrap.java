package com.mohannad.springsecurity.bootsrab;

import com.mohannad.springsecurity.model.User;
import com.mohannad.springsecurity.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * created by mohannad
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
        String pass = encoder.encode("123456");
        System.out.println("pasword --------------------- ="+pass);
        user.setPassword(pass);
        user.setUsername("mnono");
        user.setEmail("mohanadElmaghrby@gmail.com");

        userRepository.save(user);
        System.out.println("+++++++++++++++++++++++++++++save++++++++++++++++++++++++++");
    }
}
