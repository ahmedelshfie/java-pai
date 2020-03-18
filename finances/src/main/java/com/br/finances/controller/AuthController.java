package com.br.finances.controller;

import static org.springframework.http.ResponseEntity.ok;
import java.util.HashMap;
import java.util.Map;


import com.br.finances.jwt.JwttokenProvider;
import com.br.finances.models.User;
import com.br.finances.repository.UserRepository;
import com.br.finances.security.AccountCredentialsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  JwttokenProvider provider;

  @Autowired
  private UserRepository repository;

  @PostMapping
  public ResponseEntity createAuth(@RequestBody AccountCredentialsDTO data) {

    System.out.println(" DATA ::::::::::::::::::::::::::::::::::::::::::::  "+ data);
    try {

      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));

      User user = repository.findByUsername(data.getUsername());
      String token = "";
      if (user != null) {
        token = provider.createToken(data.getUsername(), user.getRoles());
      } else {
        throw new UsernameNotFoundException("Username "+ data.getUsername() + "not found");
      }

      Map<Object, Object> model = new HashMap<>();
      model.put("username", data.getUsername());
      model.put("token", token);
      return ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
  }
}
