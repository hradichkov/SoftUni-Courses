package com.example.bookshop.repositories;

import com.example.bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(Long id);

    Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate localDate);

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    Optional<List<Author>> findAllDistinctOrderByBooks();
}

