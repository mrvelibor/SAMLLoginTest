package com.mrvelibor.logintest.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protektor")
public class ProtectedController {

    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("@securityService.hasProtectedAccess()")
    public ResponseEntity<?> getDaHoney() {
        return ResponseEntity.ok("You are authorized!");
    }

}
