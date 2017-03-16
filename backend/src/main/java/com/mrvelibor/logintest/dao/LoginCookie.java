/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.dao;

import com.mrvelibor.logintest.utils.Hashish;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Velibor
 */
@Entity
@Table(name = "cookies")
public class LoginCookie {

    @Id
    private String token;
    @NotNull
    private String username;

    public LoginCookie() {}

    public LoginCookie(LoginUser user) {
        this.username = user.username;
        this.token = Hashish.GenerateCookie();
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format(
            "LoginCookie[token='%s', username='%s']",
            token,
            username);
    }
    
}
