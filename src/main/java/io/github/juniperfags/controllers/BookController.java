package io.github.juniperfags.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.github.juniperfags.dtos.book.CreateBookDto;
import io.github.juniperfags.dtos.book.BookResponse;
import io.github.juniperfags.mappers.BookMapper;
import io.github.juniperfags.services.BookService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController()
@RequestMapping("/api/book")
public class BookController {

  private final BookService bookService;
  private final BookMapper bookMapper;

  public BookController(BookService bookService, BookMapper bookMapper) {
    this.bookService = bookService;
    this.bookMapper = bookMapper;
  }

  @PostMapping("/create")
  public BookResponse create(@RequestBody @Valid CreateBookDto requestBody) {
    return this.bookMapper.toResponse(this.bookService.create(requestBody));
  }

  @GetMapping("/list")
  public List<BookResponse> list() {
    return this.bookMapper.toResponse(this.bookService.list());
  }

  @GetMapping("/find/{id}")
  public BookResponse find(@PathVariable Long id) {
    return this.bookMapper.toResponse(this.bookService.findById(id));
  }

}
