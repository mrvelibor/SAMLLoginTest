/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.controller;

import com.mrvelibor.logintest.dao.LoginCookie;
import com.mrvelibor.logintest.dao.LoginUser;
import com.mrvelibor.logintest.errors.BadRequestException;
import com.mrvelibor.logintest.errors.ForbiddenException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrvelibor.logintest.repos.LoginCookieRepository;
import com.mrvelibor.logintest.repos.LoginUserRepository;
import com.mrvelibor.logintest.utils.Hashish;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Velibor
 */
@RestController
public class LoginCookieController {
    
    @Autowired
    private LoginCookieRepository cookieRepo;    
    @Autowired
    private LoginUserRepository userRepo;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginUser logIn(@RequestParam(value="username") String username, @RequestParam(value="password", defaultValue="") String password, HttpServletResponse response) {
        if(username.isEmpty()) {
            throw new BadRequestException("Parameter 'username' must not be empty.");
        }		
        LoginUser user = userRepo.findByUsername(username);
        if(user == null) {
            throw new ForbiddenException("Parameters 'username' or 'password' don't match.");
        }
        if(!user.password.equals(Hashish.HashPassword(password))) {
            throw new ForbiddenException("Parameters 'username' or 'password' don't match.");
        }
        user.setType(1);

        LoginCookie cookie = cookieRepo.save(new LoginCookie(user));
        try {
            response.addCookie(new Cookie("token", URLEncoder.encode(cookie.getToken(), "UTF-8")));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginCookieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
}
