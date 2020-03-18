package com.br.finances.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  @Autowired
  private JwttokenProvider tokeJwttokenProvider;

  public JwtConfigurer(JwttokenProvider tokeJwttokenProvider) {
    this.tokeJwttokenProvider = tokeJwttokenProvider;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    JwtFilter customerFilter = new JwtFilter(this.tokeJwttokenProvider);
    http.addFilterBefore(customerFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
