package com.br.finances.jwt;

import com.br.finances.exceptions.ExceptionResponse;
import com.br.finances.exceptions.InvalidJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwttokenProvider {

  @Value("${security.jwt.token.secret-key:secret}")
  private String securityKey = "secret";

  @Value("${security.jwt.token.expire-lenght:36000000}")
  private long validTyMilliseconds = 36000000;

  @Autowired
  private UserDetailsService userDetailsService;


  @PostConstruct
  public void init() {
    securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
  }

  public String createToken(String username, List<String> roles) {

    Claims claims = Jwts.claims().setSubject(username);
    claims.put("roles", roles);
    Date now = new Date();
    Date validify = new Date(now.getTime() + validTyMilliseconds);

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(validify)
        .signWith(SignatureAlgorithm.ES256, securityKey)
        .compact();
  }


  public Authentication getAuthentication(String token) {
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  private String getUsername(String token) {
    return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveToken(HttpServletRequest req) {
    String bearToken = req.getHeader("Authorization");
    if (bearToken != null && bearToken.startsWith("Bearer ")) {
      return bearToken.substring(7, bearToken.length());
    }
    return securityKey;
  }

  public boolean validateToken(String token) {
    try {
      Jws<Claims> claimsJws = Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
      if (claimsJws.getBody().getExpiration().before(new Date())) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
