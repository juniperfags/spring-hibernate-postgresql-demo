package io.github.juniperfags.services;

import java.util.List;
import java.util.Optional;

import io.github.juniperfags.dtos.book.CreateBookDto;
import io.github.juniperfags.models.Book;

public interface BookService {

  List<Book> list();

  Optional<Book> findById(Long id);

  Book create(CreateBookDto createBookDto);

}