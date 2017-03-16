/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

/**
 *
 * @author Velibor
 */
public class Hashish {
    
    private Hashish() {}

    private static final MessageDigest digest;
    private static final KeyGenerator keyGen;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to initiate Hash class.");
        }
    }

    public static String HashPassword(String password) {
        return new String(digest.digest(password.getBytes()));
    }

    public static String GenerateCookie() {
        return new String(keyGen.generateKey().getEncoded());
    }
    
}
