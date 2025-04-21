package io.github.juniperfags.configuration.security;

import io.github.juniperfags.configuration.security.filters.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  SecurityFilterChain appChain(HttpSecurity http) throws Exception {
    http.securityMatcher("/api/**").csrf(Customizer.withDefaults())
        .addFilterAfter(new JwtAuthFilter(), AnonymousAuthenticationFilter.class)
        .authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/public/**").permitAll()
            .requestMatchers("/api/private/**").authenticated());
    return http.build();
  }

  @Bean
  SecurityFilterChain authorizationSecurityChain(HttpSecurity http) throws Exception {
    http.securityMatcher("/login/**").csrf(csrf -> csrf.ignoringRequestMatchers("/login/**"))
        .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
    return http.build();
  }

}
