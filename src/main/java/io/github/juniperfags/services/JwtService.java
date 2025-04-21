package io.github.juniperfags.services;

import io.github.juniperfags.configuration.security.utils.JwtUtils;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

  public String createJwt(String tokenContent) {
    return JwtUtils.encode(tokenContent);
  }

}
