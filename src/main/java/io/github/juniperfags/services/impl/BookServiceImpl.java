package io.github.juniperfags.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.juniperfags.dtos.book.CreateBookDto;
import io.github.juniperfags.models.Book;
import io.github.juniperfags.repositories.BookRepository;
import io.github.juniperfags.services.BookService;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> list() {
    return this.bookRepository.findAll();
  }

  @Override
  public Optional<Book> findById(Long id) {
    return this.bookRepository.findById(id);
  }

  @Override
  public Book create(CreateBookDto createBookDto) {
    Book book = new Book();

    book.setTitle(createBookDto.getTitle());
    book.setDescription(createBookDto.getDescription());
    book.setAuthor(createBookDto.getAuthor());

    return this.bookRepository.save(book);

  }

}