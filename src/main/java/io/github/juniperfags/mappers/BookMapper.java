package io.github.juniperfags.mappers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import io.github.juniperfags.dtos.book.BookResponse;
import io.github.juniperfags.exceptions.EntityNotFoundException;
import io.github.juniperfags.models.Book;

@Component
public class BookMapper {

  public List<BookResponse> toResponse(List<Book> list) {
    return list.stream().map((element) -> new BookResponse(element.getId(), element.getTitle(),
        element.getDescription(), element.getAuthor())).toList();
  }

  public BookResponse toResponse(Optional<Book> book) {

    if (!book.isPresent())
      throw new EntityNotFoundException();

    Book element = book.get();

    return new BookResponse(element.getId(), element.getTitle(), element.getDescription(),
        element.getAuthor());
  }

  public BookResponse toResponse(Book element) {
    return new BookResponse(element.getId(), element.getTitle(), element.getDescription(),
        element.getAuthor());
  }

}