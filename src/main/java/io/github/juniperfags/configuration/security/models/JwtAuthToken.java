package io.github.juniperfags.configuration.security.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtAuthToken implements Serializable {

  private List<String> roles;

  private String name;

}
