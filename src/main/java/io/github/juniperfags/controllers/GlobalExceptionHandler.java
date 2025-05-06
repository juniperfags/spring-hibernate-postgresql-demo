package io.github.juniperfags.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.juniperfags.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Map<String, Object>> entityNotFoundExceptionHandler(
      EntityNotFoundException ex) {
    Map<String, Object> error = new HashMap<>();
    error.put("message", ex.getMessage());
    error.put("code", HttpStatus.NOT_FOUND.value());
    error.put("timestamp", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> genericExceptionHandler(Exception ex) {
    Map<String, Object> error = new HashMap<>();
    error.put("mensaje", "Something went wrong in server...");
    error.put("detalle", ex.getMessage());
    error.put("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
    error.put("timestamp", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}