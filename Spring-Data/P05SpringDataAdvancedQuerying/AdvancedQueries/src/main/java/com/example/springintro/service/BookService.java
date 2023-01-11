package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<String> findAllByPriceLessThanAndPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<String> findAllByReleaseDateNot(LocalDate localDate);

    List<String> findAllBooksWithReleaseDateBefore(LocalDate date);

    List<String> findAllByTitleContains(String str);

    List<String> findAllByAuthorLastNameStartingWith(String str);

    int countAllByTitleSizeGreaterThan(int num);

    int countAllCopiesByAuthor(String firstName, String lastName);

    Book findFirstByTitle(String title);

    int increaseBookCopies(int copies, LocalDate date);

    int deleteBookByCopiesLessThan(Integer copies);

}
