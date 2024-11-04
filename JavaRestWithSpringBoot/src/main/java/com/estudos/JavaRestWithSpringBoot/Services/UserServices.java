package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServices implements UserDetailsService {
    private final Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name!");
        var user = repository.findByUserName(username);
        if(user == null) {
            throw  new UsernameNotFoundException("Username " + username + "not found!");
        }
        return user;
    }
}
