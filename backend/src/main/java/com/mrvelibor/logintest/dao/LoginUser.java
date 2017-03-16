/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Velibor
 */
@Entity
@Table(name = "users")
public class LoginUser {
    
    @Id
    public String username;
    
    @NotNull
    @JsonIgnore
    public String password;
    
    @JsonInclude()
    @Transient
    public int type;
    
    public LoginUser() {
        
    }
    
    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "LoginUser[username='%s'; password='%s']",
                username,
                password);
    }   
    
}
