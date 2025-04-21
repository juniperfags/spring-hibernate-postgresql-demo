package io.github.juniperfags.configuration.security.filters;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import io.github.juniperfags.configuration.security.authentication.JwtAuthenticationToken;
import io.github.juniperfags.configuration.security.models.JwtAuthToken;
import io.github.juniperfags.configuration.security.utils.JwtUtils;
import io.github.juniperfags.shared.BearerToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {

  private static final Logger fileLogger = LoggerFactory.getLogger(JwtAuthFilter.class);

  private void securityContextConfiguration(JwtAuthToken token) {
    SecurityContext context = SecurityContextHolder.createEmptyContext();

    Authentication jwtAuthenticationToken = new JwtAuthenticationToken(token, "[JWT_CREDENTIALS]",
        AuthorityUtils.createAuthorityList(token.getRoles()));

    context.setAuthentication(jwtAuthenticationToken);

    SecurityContextHolder.setContext(context);

  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    try {

      fileLogger.info("Getting servlet path at {} [ {} ] ", JwtAuthFilter.class.getName(),
          request.getServletPath());

      if (request.getServletPath().startsWith("/api/public")) {

        filterChain.doFilter(request, response);
        return;

      }

      String authorizationHeader = request.getHeader("Authorization");

      fileLogger.info("Authorization Header at Incoming Request [ {} ]", authorizationHeader);

      CsrfToken csrf = (CsrfToken) request.getAttribute("_csrf");

      String csrfToken = (csrf != null) ? csrf.getToken() : "NOT FOUND";

      fileLogger.info("CSRF token found at Incoming Request [ {} ]", csrfToken);

      if (!BearerToken.hasBearerToken(authorizationHeader)) {
        throw new AccessDeniedException("Missing Authorization header at Request");
      }

      String jwt = authorizationHeader.split(" ")[1];

      Claims claims = JwtUtils.retrieveClaims(jwt);

      this.securityContextConfiguration(JwtUtils.mapClaimsToModel(claims));

      filterChain.doFilter(request, response);

    } catch (Exception ex) {

      int httpStatusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

      if (ex instanceof AccessDeniedException) {

        httpStatusCode = HttpServletResponse.SC_UNAUTHORIZED;
      }

      if (ex instanceof JwtException) {

        httpStatusCode = HttpServletResponse.SC_FORBIDDEN;
      }

      response.setContentType("application/json");
      response.setStatus(httpStatusCode);
      response.getWriter().write("{\"error\": \"" + ex.getMessage() + "\"}");

    }
  }
}
