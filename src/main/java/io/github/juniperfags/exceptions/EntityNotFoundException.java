package io.github.juniperfags.exceptions;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(Long id) {
    super(String.format("Entity with id %d not exists...", id));
  }

  public EntityNotFoundException() {
    super("Entity not exists...");
  }
}