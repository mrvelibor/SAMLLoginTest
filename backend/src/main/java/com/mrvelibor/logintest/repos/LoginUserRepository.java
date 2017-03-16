/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.repos;

import org.springframework.data.repository.CrudRepository;

import com.mrvelibor.logintest.dao.LoginUser;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Velibor
 */
public interface LoginUserRepository extends CrudRepository<LoginUser, String> {

    LoginUser findByUsername(@Param("username") String username);
    
}