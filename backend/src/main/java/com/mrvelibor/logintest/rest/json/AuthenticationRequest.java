package com.mrvelibor.logintest.rest.json;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}
