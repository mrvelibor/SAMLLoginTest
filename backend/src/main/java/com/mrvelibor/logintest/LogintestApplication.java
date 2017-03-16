package com.mrvelibor.logintest;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.EnableSAMLSSO;
import com.mrvelibor.logintest.dao.LoginUser;
import com.mrvelibor.logintest.repos.LoginCookieRepository;
import com.mrvelibor.logintest.repos.LoginUserRepository;
import com.mrvelibor.logintest.utils.Hashish;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableSAMLSSO
public class LogintestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LogintestApplication.class, args);
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer customizer() {
        return container -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
            }
        };
    }

    @Autowired
    private LoginUserRepository userRepo;
    @Autowired
    private LoginCookieRepository cookieRepo;
    
    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        cookieRepo.deleteAll();
        
        LoginUser user = userRepo.save(new LoginUser("test", Hashish.HashPassword("test")));
        System.err.println(user);
    }
    
}
