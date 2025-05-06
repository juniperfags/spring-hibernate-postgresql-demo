package io.github.juniperfags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.juniperfags.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}