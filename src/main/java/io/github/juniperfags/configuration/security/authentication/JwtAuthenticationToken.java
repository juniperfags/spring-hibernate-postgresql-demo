package io.github.juniperfags.configuration.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private Object principal;

  private final Object credentials;

  public JwtAuthenticationToken(Object principal, Object credentials,
      Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    this.credentials = credentials;
    setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return credentials;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

}
