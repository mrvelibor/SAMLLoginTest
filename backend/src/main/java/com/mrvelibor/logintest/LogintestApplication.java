package com.mrvelibor.logintest;

import com.mrvelibor.logintest.dao.LoginUser;
import com.mrvelibor.logintest.repos.LoginUserRepository;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LogintestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogintestApplication.class, args);
    }
    
}
