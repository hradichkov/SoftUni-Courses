package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateNot(LocalDate localDate);

    List<Book> findAllByTitleContains(String str);

    List<Book> findAllByAuthorLastNameStartingWith(String str);

    @Query("SELECT COUNT(b) FROM Book b " +
            "WHERE length(b.title) > :num")
    int countAllByTitleSizeGreaterThan(int num);

    @Query("SELECT SUM(b.copies) FROM Book b " +
            "WHERE b.author.firstName = :firstName And b.author.lastName = :lastName")
    int countAllCopiesByAuthor(String firstName, String lastName);

    Book findFirstByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :copies " +
            "WHERE b.releaseDate > :date")
    int increaseBookCopies(int copies, LocalDate date);

    @Transactional
    int deleteBookByCopiesLessThan(Integer copies);
}
