package com.mrvelibor.logintest.utils;

import com.mrvelibor.logintest.dao.LoginUser;
import com.mrvelibor.logintest.repos.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private LoginUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LoginUser user = this.userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
      return new StupidUser(user.getUsername(), user.getPassword(), new HashSet<>());
    }
  }

}
