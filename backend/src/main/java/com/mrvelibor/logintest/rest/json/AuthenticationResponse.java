package com.mrvelibor.logintest.rest.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationResponse {

    @Getter @Setter
    private String token;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String type;

}
