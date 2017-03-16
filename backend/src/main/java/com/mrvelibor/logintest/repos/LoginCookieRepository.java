/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.repos;

import com.mrvelibor.logintest.dao.LoginCookie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Velibor
 */
public interface LoginCookieRepository extends CrudRepository<LoginCookie, String> {

    List<LoginCookie> findByUsername(@Param("username") String username);
    
}