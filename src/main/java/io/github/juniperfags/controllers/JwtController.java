package io.github.juniperfags.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.github.juniperfags.services.JwtService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("/login")
public class JwtController {

  private JwtService jwtService;

  JwtController(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  @PostMapping("/jwt")
  public String postMethodName(@RequestBody String entity) {
    return jwtService.createJwt(entity);
  }

}
