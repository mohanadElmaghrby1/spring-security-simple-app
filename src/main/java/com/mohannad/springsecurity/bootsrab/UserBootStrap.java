package com.mohannad.springsecurity.bootsrab;

import com.mohannad.springsecurity.model.Role;
import com.mohannad.springsecurity.model.User;
import com.mohannad.springsecurity.repository.UserRepository;
import org.h2.bnf.Rule;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

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
        //create user
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode("123456");
        System.out.println("password --------------------- ="+encodedPass);
        user.setPassword(encodedPass);
        user.setUsername("mohannad20");
        user.setEmail("mohannad.elmaghrby@gmail.com");

        //create user
        User userAdmin = new User();
        String adminPAss = encoder.encode("654321");
        System.out.println("password admin --------------------- ="+adminPAss);
        userAdmin.setPassword(adminPAss);
        userAdmin.setUsername("admin202");
        userAdmin.setEmail("Amohannad.elmaghrby@gmail.com");

        //create role
        Role roleUser = new Role();
        roleUser.setRole("USER");

        //create role
        Role roleAdmin = new Role();
        roleAdmin.setRole("ADMIN");

        HashSet<Role> roleHashSet = new HashSet<>();
        roleHashSet.add(roleUser);
        user.setRoles(roleHashSet);

        HashSet<Role> adminHashSet = new HashSet<>();
        roleHashSet.add(roleAdmin);
        userAdmin.setRoles(adminHashSet);

        userRepository.save(user);
        userRepository.save(userAdmin);

        System.out.println("dummy data saved");
    }
}
