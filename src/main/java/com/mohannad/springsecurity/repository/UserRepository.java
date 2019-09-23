package com.mohannad.springsecurity.repository;


import com.mohannad.springsecurity.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}