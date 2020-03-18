package com.br.finances.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

  @Autowired
  private JwttokenProvider tokeJwttokenProvider;

  public JwtFilter(JwttokenProvider tokeJwttokenProvider) {
    this.tokeJwttokenProvider = tokeJwttokenProvider;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    String token = tokeJwttokenProvider.resolveToken((HttpServletRequest) request);
    if (token != null && tokeJwttokenProvider.validateToken(token)) {
      Authentication auth = tokeJwttokenProvider.getAuthentication(token);
      if (auth != null) {
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }
    chain.doFilter(request, response);
  }
}
