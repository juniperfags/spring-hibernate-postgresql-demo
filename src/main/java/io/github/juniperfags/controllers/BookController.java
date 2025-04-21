package io.github.juniperfags.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.github.juniperfags.configuration.security.models.JwtAuthToken;
import io.github.juniperfags.services.StringService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("/api")
public class BookController {

  private StringService stringService;

  public BookController(StringService stringService) {
    this.stringService = stringService;
  }

  @GetMapping("/public")
  public String publicMethod() {
    return stringService.getProjectName();
  }

  @GetMapping("/private")
  public String privateMethod(@RequestBody Object requestBody, Authentication authentication) {

    JwtAuthToken token = (JwtAuthToken) authentication.getPrincipal();

    return String.format("User %s welcome to the private route", token.getName());
  }

}
