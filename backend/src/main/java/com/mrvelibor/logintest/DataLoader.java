package com.mrvelibor.logintest;

import com.mrvelibor.logintest.dao.LoginUser;
import com.mrvelibor.logintest.repos.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Velibor on 19-Mar-17.
 */
@Component
public class DataLoader implements ApplicationRunner {

    private LoginUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(LoginUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        userRepository.deleteAll();
        userRepository.save(new LoginUser("velja", passwordEncoder.encode("asdf")));
    }
}