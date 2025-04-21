package io.github.juniperfags.configuration.security.utils;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.juniperfags.configuration.security.models.JwtAuthToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {

  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  private static final String SPLITTER = ":";

  private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  public static String encode(String content) {

    return Jwts.builder().setSubject(content).claim("roles", "USER:CUSTOMER")
        .signWith(SECRET_KEY, SignatureAlgorithm.HS256).compact();
  }

  public static Claims retrieveClaims(String jwtToken) {

    logger.info("Trying to parse [ {} ] to claims", jwtToken);

    return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(jwtToken)
        .getBody();
  }

  public static JwtAuthToken mapClaimsToModel(Claims claims) {

    logger.info("Trying to map from claims [ {} ] to [ {} ] class", claims.toString(),
        JwtAuthToken.class.getSimpleName());

    return new JwtAuthToken(getRoles((String) claims.get("roles")), claims.getSubject());

  }

  private static List<String> getRoles(String roles) {

    List<String> list = new ArrayList<>();

    String[] result = roles.split(SPLITTER);

    Arrays.copyOf(result, result.length);

    return list;

  }

}
