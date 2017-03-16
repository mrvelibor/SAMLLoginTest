/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrvelibor.logintest;

import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderBuilder;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Velibor
 */
@Configuration
public class MyServiceProviderConfig extends ServiceProviderConfigurerAdapter {
    @Override
    public void configure(ServiceProviderBuilder serviceProvider) throws Exception {
        // @formatter:off
        serviceProvider 
            .metadataGenerator() //(1)
            .entityId("localhost-demo")
        .and()
            .sso() //(2)
            .defaultSuccessURL("/home")
            .idpSelectionPageURL("/idpselection")
        .and()
            .logout() //(3)
            .defaultTargetURL("/")
        .and()
            .metadataManager() //(4)
            .metadataLocations("classpath:/idp-ssocircle.xml")
            .refreshCheckInterval(0)
        .and()
            .extendedMetadata() //(5)
            .idpDiscoveryEnabled(true)
        .and()
            .keyManager() //(6)
            .privateKeyDERLocation("classpath:/localhost.key.der")
            .publicKeyPEMLocation("classpath:/localhost.cert");
        // @formatter:on
    }
}
